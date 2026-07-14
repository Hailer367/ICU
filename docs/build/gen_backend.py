#!/usr/bin/env python3
"""Generate: iCare MC - Backend Architecture & Data Model (PDF 2 of 3)."""
import os
from reportlab.platypus import Spacer, Paragraph, PageBreak, NextPageTemplate
import pdf_kit
from pdf_kit import (styles, DocTemplate, hr, bullets, numbered, code_block,
                     data_table, callout, cover)

OUT = os.path.join(os.path.dirname(__file__), "..", "..",
                   "iCareMC_Backend_Architecture.pdf")


def build():
    ss = styles()
    doc = DocTemplate(OUT, "iCare MC \u2014 Backend Architecture & Data Model",
                      "Backend Architecture & Data Model \u2014 2 / 3")
    e = []

    e += cover(
        ss, "TECHNICAL ARCHITECTURE  \u2022  DOC 2 / 3",
        ["Backend Architecture", "&amp; Data Model"],
        "The server side of iCare MC: the shared Supabase project, its "
        "PostgreSQL schema, storage, serverless functions and companion services.",
        [("Subject", "Shared backend for patient + doctor apps"),
         ("Core", "Supabase (PostgreSQL, GoTrue, Realtime, Storage, Edge)"),
         ("Glue", "Vercel serverless (admin/push, Chapa banks) + Betegna SMS"),
         ("Payments", "Chapa gateway with in-app wallet"),
         ("Messaging", "Firebase Cloud Messaging"),
         ("Method", "Inferred from client calls, table refs &amp; column lists")],
    )
    e.append(NextPageTemplate("Content"))
    e.append(PageBreak())

    # TOC
    e.append(Paragraph("Contents", ss["H1"]))
    e.append(hr(pdf_kit.BRAND))
    for n, t in [
        ("1", "Backend topology"),
        ("2", "Supabase as the system of record"),
        ("3", "The PostgreSQL data model"),
        ("4", "Row-Level Security &amp; access model"),
        ("5", "Serverless / Edge Function responsibilities"),
        ("6", "Companion backends (SMS, push, Chapa banks)"),
        ("7", "Domain workflows end-to-end"),
        ("8", "Content, localisation &amp; reference data"),
        ("9", "Operational concerns &amp; hardening"),
    ]:
        e.append(data_table(ss, ["", ""], [[n, t]], [0.08, 0.92]))
        e.append(Spacer(1, 1))
    e.append(PageBreak())

    # 1 topology
    e.append(Paragraph("1&nbsp;&nbsp;Backend topology", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "iCare MC has no traditional application server that the apps own. The "
        "backend is a composition of managed platforms, with a single "
        "<b>Supabase project</b> at the centre acting as database, auth server, "
        "realtime broker, object store and function host. Two lightweight "
        "serverless surfaces on Vercel and an SMS gateway provide the glue that "
        "Supabase does not cover out of the box.", ss["Body"]))
    e.append(code_block(ss,
        "  Patient app (icare_mc) ─┐                 ┌─ Doctor app (icare_doctors)\n"
        "                          v                 v\n"
        "                 ┌───────────────────────────────┐\n"
        "                 │  SUPABASE  (single shared proj) │\n"
        "                 │  bjripaytpikgjvroypru           │\n"
        "                 │  • PostgreSQL  (/rest/v1)       │\n"
        "                 │  • GoTrue auth (/auth/v1)       │\n"
        "                 │  • Realtime    (/realtime/v1)   │\n"
        "                 │  • Storage     (/storage/v1)    │\n"
        "                 │  • Edge fns    (/functions/v1)  │\n"
        "                 └───────────────────────────────┘\n"
        "        ┌─────────────────┼──────────────────┐\n"
        "        v                 v                  v\n"
        "  Vercel admin API   Betegna SMS API     Chapa gateway\n"
        "  (push/broadcast/   (/sms/send-otp,     (/inline/charge,\n"
        "   chapa-banks)       /sms/verify-otp)    /inline/validate)\n"
        "        │\n"
        "        └──> Firebase Cloud Messaging  ──> devices"))
    e.append(callout(ss, "Single shared project, two audiences",
        "Because both apps use the same Supabase project and anon key, the "
        "database schema itself must separate patient-visible and doctor-visible "
        "data using row policies and an <font face='Courier'>account type / role</font> "
        "attribute on the profile. This is the backbone of the whole design.",
        "note"))
    e.append(PageBreak())

    # 2 supabase system of record
    e.append(Paragraph("2&nbsp;&nbsp;Supabase as the system of record", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Supabase runs a managed PostgreSQL instance fronted by PostgREST. Client "
        "&ldquo;repositories&rdquo; "
        "(<font face='Courier'>supabase_repository.dart</font>, "
        "<font face='Courier'>doctor_repository.dart</font>, "
        "<font face='Courier'>chat_repository.dart</font>, "
        "<font face='Courier'>patient_wallet_repository.dart</font>, "
        "<font face='Courier'>review_repository.dart</font>) issue REST calls that "
        "the database answers directly, applying Row-Level Security per request.",
        ss["Body"]))
    e.append(Paragraph("Server-side responsibilities", ss["H3"]))
    e.append(bullets(ss, [
        "<b>Relational storage</b> of profiles, children, appointments, messages, "
        "services, wallet and content tables.",
        "<b>Identity</b> &mdash; GoTrue owns the users table, password hashing and "
        "JWT issuance/refresh.",
        "<b>Authorisation</b> &mdash; Postgres RLS policies decide which rows each "
        "authenticated user may read/write.",
        "<b>Realtime fan-out</b> &mdash; logical-replication stream powers chat and "
        "message subscriptions.",
        "<b>Object storage</b> &mdash; buckets for child photos, doctor profile "
        "images, service images and verification documents.",
        "<b>Business logic</b> &mdash; transactional operations are pushed into "
        "Postgres functions (RPC) and Edge Functions.",
    ]))
    e.append(Paragraph(
        "The client explicitly detects when the deployed schema is behind the app: "
        "<i>&ldquo;Cloud database is missing tables or columns. Ask your admin to "
        "run the Supabase migrations, then try again.&rdquo;</i> This confirms a "
        "migration-driven schema managed outside the app.", ss["Body"]))
    e.append(PageBreak())

    # 3 data model
    e.append(Paragraph("3&nbsp;&nbsp;The PostgreSQL data model", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "The tables below are reconstructed from table references, "
        "<font face='Courier'>select=</font> column lists, model "
        "<font face='Courier'>fromSupabaseRow / fromJson</font> factories and "
        "domain strings inside both binaries. Column lists shown are those "
        "directly observed; a real schema will contain additional bookkeeping "
        "columns (ids, timestamps).", ss["Body"]))

    e.append(Paragraph("3.1&nbsp;&nbsp;Identity &amp; people", ss["H2"]))
    e.append(data_table(ss,
        ["Table", "Represents", "Key observed columns"],
        [["profiles", "Base account (patient or doctor)",
          "id, account type/role, name, email, phone"],
         ["doctor_profiles", "Doctor-specific profile",
          "first_name, last_name, specialty, hospital, phone, profile_photo_url"],
         ["user_profile (model)", "Patient profile view",
          "name, email, phone, account type"],
         ["hospitals", "Hospital directory (doctor sign-up)",
          "id, name, &hellip; (searchable field)"]],
        [0.22, 0.34, 0.44], mono_cols=()))

    e.append(Paragraph("3.2&nbsp;&nbsp;Child health domain (patient app)", ss["H2"]))
    e.append(data_table(ss,
        ["Table", "Represents", "Key observed columns"],
        [["children", "A child record",
          "id, user_id, local_id, name, birth data"],
         ["child_growth_measurement", "Weight/height entries",
          "weight, height, symptoms, notes, blood_pressure_*, temperature"],
         ["child_vaccine_record", "Given/marked vaccines",
          "user_id, child_local_id, vaccine_key, status"],
         ["child_followup_visit", "Scheduled follow-up visits",
          "id, child_local_id, template_id, due_date, status, completed_at, checklist"],
         ["child_followup_visit_templates", "Visit definitions",
          "code, label, sort_order, modules, vaccines"],
         ["child_growth_periods", "Age-band content",
          "age_months, age_label, age_group, offset_days, growth_metrics"],
         ["vaccine_dose_schedule", "Dose calendar",
          "code, display_name, dose_number, series_code, eligible_from/until_days"]],
        [0.24, 0.30, 0.46], mono_cols=()))

    e.append(PageBreak())
    e.append(Paragraph("3.3&nbsp;&nbsp;Pregnancy domain (patient app)", ss["H2"]))
    e.append(data_table(ss,
        ["Table", "Represents", "Key observed columns"],
        [["pregnancy_record", "A tracked pregnancy",
          "user_id, dates (LMP / due date)"],
         ["pregnancy_week_log", "Per-week journal", "week, log data"],
         ["pregnancy_weeks / _translations", "Week content + i18n",
          "week_number, image_url, trimester, title, subtitle, baby_development, "
          "mother_changes, recommendations, warning_signs, sections"]],
        [0.26, 0.28, 0.46], mono_cols=()))

    e.append(Paragraph("3.4&nbsp;&nbsp;Doctors, services &amp; bookings", ss["H2"]))
    e.append(data_table(ss,
        ["Table", "Represents", "Key observed columns"],
        [["doctors", "Doctor directory entry", "id, profile fields, category"],
         ["doctor_categories", "Specialty categories", "id, name, slug, sort_order"],
         ["doctor_services", "Bookable services", "id, doctor_id, name, price"],
         ["service_listing (model)", "Rendered service card", "service + doctor join"],
         ["appointments", "Booked appointments",
          "appointment_date, time_slot, service_name, status, payment_status, total_amount"],
         ["bookings", "Booking transaction", "booking + payment refs (Chapa tx_ref)"],
         ["service_reviews", "Ratings after a visit", "rating, comment, service_id"]],
        [0.22, 0.30, 0.48], mono_cols=()))

    e.append(Paragraph("3.5&nbsp;&nbsp;Messaging, money &amp; system", ss["H2"]))
    e.append(data_table(ss,
        ["Table", "Represents", "Key observed columns"],
        [["conversations", "Chat thread (doctor \u2194 patient)", "id, participants"],
         ["messages", "Chat messages", "conversation/thread id, sender, body, sent_at"],
         ["patient_wallets", "Patient wallet balance", "user_id, balance"],
         ["wallet_transactions", "Wallet ledger (doctor payouts too)", "amount, type, ref"],
         ["bank_details", "Doctor payout bank (Chapa)", "bank, account, doctor_id"],
         ["payment_settings", "Chapa keys &amp; fee config",
          "public/secret key, fee percent"],
         ["care_subscriptions", "Care plan subscription", "user_id, plan, status"],
         ["daily_tips", "Daily health tips (+translations)", "tip_id, language_code, title, content"],
         ["legal_documents", "Terms / privacy content", "type, body"],
         ["app_settings (doctor)", "Remote config / version policy", "key, value"],
         ["fcm_tokens", "Device push tokens", "user_id, fcm_token, platform"]],
        [0.20, 0.32, 0.48], mono_cols=()))
    e.append(callout(ss, "Offline-friendly IDs",
        "Several child tables carry both a server id and a "
        "<font face='Courier'>local_id / child_local_id</font>. This dual-key "
        "pattern lets the app create records offline (guest/demo mode) and "
        "reconcile them with the server once the user signs in.", "note"))

    e.append(PageBreak())
    # 4 RLS
    e.append(Paragraph("4&nbsp;&nbsp;Row-Level Security &amp; access model", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Because the client only ever holds the public <b>anon</b> key plus a "
        "per-user JWT, all real authorisation must live in Postgres RLS. The "
        "expected policy shape, inferred from the data model:", ss["Body"]))
    e.append(bullets(ss, [
        "<b>Ownership</b> &mdash; patient tables (children, measurements, "
        "vaccines, wallet) are restricted to rows where "
        "<font face='Courier'>user_id = auth.uid()</font>.",
        "<b>Role split</b> &mdash; the <font face='Courier'>profiles</font> "
        "row carries an account-type/role; doctor-only tables (services, bank "
        "details, availability) are writable only by the owning doctor.",
        "<b>Shared conversations</b> &mdash; a message row is visible to the two "
        "participants of its conversation; appointments are visible to both the "
        "booking patient and the target doctor.",
        "<b>Public reference data</b> &mdash; content tables (tips, pregnancy "
        "weeks, categories, growth periods, legal docs) are world-readable "
        "under the anon key.",
    ]))
    e.append(callout(ss, "\u26A0  RLS is the only thing standing between users",
        "With a shared anon key baked into a public APK, RLS is not optional. Any "
        "table lacking a correct policy is effectively public read/write. The "
        "shipped service-role key (see the API document) must be revoked because "
        "it bypasses RLS entirely.", "warn"))
    e.append(PageBreak())

    # 5 edge functions
    e.append(Paragraph("5&nbsp;&nbsp;Serverless / Edge Function responsibilities",
                       ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Two serverless layers carry the logic that should not run on-device with "
        "the anon key:", ss["Body"]))
    e.append(Paragraph("5.1&nbsp;&nbsp;Supabase Edge Functions (/functions/v1)",
                       ss["H2"]))
    e.append(Paragraph(
        "The <font face='Courier'>functions_client</font> package and the "
        "<font face='Courier'>/functions/v1</font> path are present. Edge "
        "Functions are the correct home for privileged, secret-bearing work: "
        "verifying a Chapa payment with the secret key, atomically finalising a "
        "booking + wallet credit, and any admin mutation. They run server-side "
        "with the service-role identity that must never be exposed to the client.",
        ss["Body"]))
    e.append(Paragraph("5.2&nbsp;&nbsp;Vercel admin API (icaremc-admin)", ss["H2"]))
    e.append(Paragraph(
        "A Next.js/Vercel deployment exposes push and broadcast endpoints plus a "
        "public Chapa-bank list. It is the piece that talks to FCM with a Firebase "
        "server key and, likely, to Chapa server-side.", ss["Body"]))
    e.append(data_table(ss,
        ["Endpoint", "Responsibility"],
        [["POST /api/bookings/push", "Push on appointment create / status change"],
         ["POST /api/chat/push", "Push the counterparty on a new chat message"],
         ["POST /api/broadcast", "Admin / topic broadcast announcements"],
         ["GET /api/public/chapa-banks", "Serve Chapa payout-bank options to doctors"],
         ["(webhook)", "&lsquo;chapa webhook update&rsquo;, &lsquo;chapa verify "
          "checked&rsquo;, &lsquo;chapa transfer sent&rsquo; log strings suggest "
          "payout/verify handling"]],
        [0.34, 0.66], mono_cols=(0,)))
    e.append(PageBreak())

    # 6 companion backends
    e.append(Paragraph("6&nbsp;&nbsp;Companion backends", ss["H1"]))
    e.append(hr())
    e.append(Paragraph("6.1&nbsp;&nbsp;Betegna AI SMS gateway", ss["H2"]))
    e.append(Paragraph(
        "A dedicated OTP service issues and verifies SMS codes for phone "
        "verification and password recovery, decoupling SMS delivery (and its "
        "provider costs) from GoTrue. Endpoints "
        "<font face='Courier'>/sms/send-otp</font> and "
        "<font face='Courier'>/sms/verify-otp</font>.", ss["Body"]))
    e.append(Paragraph("6.2&nbsp;&nbsp;Firebase Cloud Messaging", ss["H2"]))
    e.append(Paragraph(
        "FCM is the delivery transport. Devices register a token, the app stores "
        "it in <font face='Courier'>fcm_tokens</font>, and the Vercel API asks FCM "
        "to deliver when events occur. The app renders alerts locally via "
        "<font face='Courier'>flutter_local_notifications</font>.", ss["Body"]))
    e.append(Paragraph("6.3&nbsp;&nbsp;Chapa payment processor", ss["H2"]))
    e.append(Paragraph(
        "Chapa handles the actual money movement (charge and, for doctors, payout "
        "transfers). The public key initiates checkout on-device; the secret key "
        "and verification/webhooks belong on the server. Doctor payout banks come "
        "from the Chapa-banks endpoint and are stored in "
        "<font face='Courier'>bank_details</font>.", ss["Body"]))
    e.append(PageBreak())

    # 7 workflows
    e.append(Paragraph("7&nbsp;&nbsp;Domain workflows end-to-end", ss["H1"]))
    e.append(hr())
    e.append(Paragraph("7.1&nbsp;&nbsp;Book &amp; pay for an appointment", ss["H2"]))
    e.append(numbered(ss, [
        "Patient opens a doctor \u2192 <font face='Courier'>doctors</font> + "
        "<font face='Courier'>doctor_services</font> read via PostgREST.",
        "Patient picks a slot; pricing is computed "
        "(<font face='Courier'>booking_pricing_utils.dart</font>) incl. Chapa fee.",
        "Chapa checkout runs on-device "
        "(<font face='Courier'>/inline/charge</font> \u2192 "
        "<font face='Courier'>/inline/validate</font>).",
        "On success an <font face='Courier'>appointments</font> / "
        "<font face='Courier'>bookings</font> row is written with the Chapa "
        "<font face='Courier'>tx_ref</font> and payment_status.",
        "The Vercel API pushes the doctor via FCM "
        "(<font face='Courier'>/api/bookings/push</font>).",
    ]))
    e.append(Paragraph("7.2&nbsp;&nbsp;Cancel &amp; refund to wallet", ss["H2"]))
    e.append(numbered(ss, [
        "Cancellation updates the appointment status.",
        "A server function credits the paid amount (minus gateway fee) to "
        "<font face='Courier'>patient_wallets</font> / "
        "<font face='Courier'>wallet_transactions</font>.",
        "User sees <i>&ldquo;@amount was credited to your wallet&rdquo;</i>.",
    ]))
    e.append(Paragraph("7.3&nbsp;&nbsp;Doctor\u2013patient chat", ss["H2"]))
    e.append(numbered(ss, [
        "Either side opens a <font face='Courier'>conversations</font> thread.",
        "Messages are inserted into <font face='Courier'>messages</font> and "
        "streamed to the other side over Realtime.",
        "A <font face='Courier'>/api/chat/push</font> call notifies the offline "
        "party via FCM.",
    ]))
    e.append(Paragraph("7.4&nbsp;&nbsp;Doctor onboarding &amp; payout", ss["H2"]))
    e.append(numbered(ss, [
        "Doctor signs up, completes personal details, uploads credentials to the "
        "<font face='Courier'>documents</font> / "
        "<font face='Courier'>credentials</font> buckets "
        "(<font face='Courier'>verify_documents</font>).",
        "Doctor sets availability and services "
        "(<font face='Courier'>doctor_services</font>).",
        "Earnings accrue; payout bank stored in "
        "<font face='Courier'>bank_details</font>; payouts settled through Chapa "
        "transfers with status tracked in "
        "<font face='Courier'>wallet_transactions</font>.",
    ]))
    e.append(PageBreak())

    # 8 content
    e.append(Paragraph("8&nbsp;&nbsp;Content, localisation &amp; reference data",
                       ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "A large part of the backend is <b>editorial content</b> served as data, "
        "so it can be updated without shipping an app release.", ss["Body"]))
    e.append(bullets(ss, [
        "<b>Localisation</b> &mdash; content tables carry sibling "
        "<font face='Courier'>*_translations</font> tables keyed by "
        "<font face='Courier'>language_code</font> (pregnancy weeks, growth "
        "periods, daily tips). Parsed by "
        "<font face='Courier'>content_translation_service.dart</font>. Oromo, "
        "Amharic and English strings are visible in the binary.",
        "<b>Pregnancy week content</b> &mdash; rich per-week guidance (baby "
        "development, mother changes, recommendations, warning signs).",
        "<b>Child growth periods</b> &mdash; age-banded milestones, vaccines, "
        "red-flags, nutrition and visit reminders.",
        "<b>WHO growth standards</b> &mdash; the LMS reference table ships "
        "<i>on-device</i> as <font face='Courier'>assets/who_lms/who_lms.json</font> "
        "(WHO Child Growth Standards, via nutriverse/zscorer) and is used by "
        "<font face='Courier'>who_zscore.dart</font> to compute z-scores locally.",
        "<b>Legal documents</b> and <b>version policy</b> are fetched from the DB "
        "so terms and force-update rules are server-controlled.",
    ]))
    e.append(callout(ss, "Hybrid data strategy",
        "Static, universal science (WHO LMS tables, milestone definitions) is "
        "bundled in the app for offline use, while operational and editorial data "
        "(appointments, chat, tips, translations, legal text) lives in Supabase so "
        "it can change without an app update.", "note"))
    e.append(PageBreak())

    # 9 ops
    e.append(Paragraph("9&nbsp;&nbsp;Operational concerns &amp; hardening", ss["H1"]))
    e.append(hr())
    e.append(data_table(ss,
        ["Area", "Current state (observed)", "Recommendation"],
        [["Secrets", "service_role + access-token secret in patient .env",
          "Revoke &amp; rotate; keep secrets server-side only"],
         ["Authorisation", "Relies on Postgres RLS via anon key",
          "Audit every table for a correct RLS policy"],
         ["Payments", "Chapa public key on client; verify server-side",
          "Confirm all charge validation/webhooks run on server"],
         ["Migrations", "App detects missing tables/columns",
          "Version schema; gate releases on migration state"],
         ["Push", "FCM via Vercel API + stored tokens",
          "Rotate stale tokens; validate authorisation on push endpoints"],
         ["Content", "DB-driven with translations",
          "Add caching / CDN for read-heavy public content"],
         ["Observability", "Client logs only (string evidence)",
          "Centralise server logs/metrics for Vercel + Edge fns"]],
        [0.16, 0.42, 0.42]))
    e.append(Spacer(1, 10))
    e.append(callout(ss, "Summary",
        "The backend is a well-factored Backend-as-a-Service design: one shared "
        "Supabase PostgreSQL project provides data, identity, realtime, storage and "
        "functions; Vercel and Betegna add push, broadcast, Chapa-bank and SMS "
        "capabilities; Chapa and FCM handle money and notifications. The schema "
        "cleanly separates identity, child-health, pregnancy, doctor/booking, "
        "messaging, wallet and content domains. Correctness of Row-Level Security "
        "and removal of the shipped service-role key are the two decisive "
        "production-readiness items.", "note"))
    e.append(Spacer(1, 6))
    e.append(Paragraph(
        "See companion documents: <b>API Architecture &amp; Configuration</b> "
        "(1/3) and <b>User-Interface Architecture</b> (3/3).", ss["Small"]))

    doc.build(e)
    print("wrote", os.path.abspath(OUT))


if __name__ == "__main__":
    build()
