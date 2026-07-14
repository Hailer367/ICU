#!/usr/bin/env python3
"""Generate: iCare MC - API Architecture & Configuration (PDF 1 of 3)."""
import os
from reportlab.platypus import Spacer, Paragraph, PageBreak, NextPageTemplate
from pdf_kit import (styles, DocTemplate, hr, bullets, numbered, code_block,
                     data_table, callout, cover)

OUT = os.path.join(os.path.dirname(__file__), "..", "..",
                   "iCareMC_API_Architecture.pdf")


def build():
    ss = styles()
    doc = DocTemplate(OUT, "iCare MC \u2014 API Architecture & Configuration",
                      "API Architecture & Configuration \u2014 1 / 3")
    e = []

    # ---- cover ----
    e += cover(
        ss, "TECHNICAL ARCHITECTURE  \u2022  DOC 1 / 3",
        ["API Architecture", "&amp; Configuration"],
        "How the iCare MC patient and doctor apps discover, authenticate to, "
        "and communicate with their cloud APIs.",
        [("Subject", "com.icaremc.app (patient) &amp; com.icaremc.doctors (doctor)"),
         ("Platform", "Flutter (Dart AOT) on Android, shared Supabase backend"),
         ("Backend", "Supabase + Vercel micro-APIs (SMS / Push / Chapa banks)"),
         ("Source", "Static analysis of release APKs (JADX + libapp.so strings)"),
         ("Status", "Reverse-engineered \u2014 names/paths recovered from AOT metadata"),
         ("Version", "patient v1.0.1 (build 6) \u2022 doctor v1.0.0 (build 3)")],
    )
    e.append(NextPageTemplate("Content"))
    e.append(PageBreak())

    # ---- TOC ----
    e.append(Paragraph("Contents", ss["H1"]))
    e.append(hr(BRAND := None or __import__("pdf_kit").BRAND))
    toc = [
        ("1", "Executive summary"),
        ("2", "API surface at a glance"),
        ("3", "Runtime configuration &amp; the .env contract"),
        ("4", "The Supabase API (REST, Auth, Realtime, Storage, Edge)"),
        ("5", "Authentication &amp; token lifecycle"),
        ("6", "Companion HTTP micro-APIs (SMS, Push, Chapa banks)"),
        ("7", "Chapa payment API integration"),
        ("8", "Firebase Cloud Messaging channel"),
        ("9", "Request construction, headers &amp; error handling"),
        ("10", "Security observations &amp; recommendations"),
    ]
    for n, t in toc:
        row = data_table(ss, ["", ""], [[n, t]], [0.08, 0.92])
        e.append(row)
        e.append(Spacer(1, 1))
    e.append(PageBreak())

    # ---- 1 exec summary ----
    e.append(Paragraph("1&nbsp;&nbsp;Executive summary", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "iCare MC is a two-app maternal &amp; child-health product: a "
        "<b>patient app</b> (<font face='Courier'>com.icaremc.app</font>, Dart "
        "package <font face='Courier'>icare_mc</font>) and a <b>doctor app</b> "
        "(<font face='Courier'>com.icaremc.doctors</font>, Dart package "
        "<font face='Courier'>icare_doctors</font>). Both are built with "
        "Flutter and compiled to native ARM/x86 libraries "
        "(<font face='Courier'>libapp.so</font>). They are thin native shells "
        "over a Dart runtime; virtually all API logic lives in Dart.", ss["Body"]))
    e.append(Paragraph(
        "The apps do <b>not</b> talk to a bespoke monolithic backend. Instead "
        "they compose several managed and serverless APIs:", ss["Body"]))
    e.append(bullets(ss, [
        "<b>Supabase</b> is the primary API &mdash; it provides the PostgREST "
        "database API, GoTrue authentication, Realtime websockets, Storage, and "
        "Edge Functions. Both apps share the <i>same</i> Supabase project "
        "(<font face='Courier'>bjripaytpikgjvroypru.supabase.co</font>).",
        "A <b>Vercel-hosted admin API</b> "
        "(<font face='Courier'>icaremc-admin.vercel.app</font>) exposes push / "
        "broadcast endpoints and a public Chapa-banks lookup.",
        "A <b>Betegna AI SMS gateway</b> "
        "(<font face='Courier'>betegna-ai.vercel.app</font>) issues and verifies "
        "phone OTP codes.",
        "<b>Chapa</b> (Ethiopian payment processor) is called for in-app "
        "checkout/charge and validation.",
        "<b>Firebase Cloud Messaging</b> delivers device push notifications.",
    ]))
    e.append(callout(ss, "How these names were recovered",
        "Release builds are obfuscated at the Java/Kotlin layer (R8/ProGuard), "
        "but Flutter&rsquo;s AOT snapshot retains Dart library URIs, class names, "
        "and many string literals inside <font face='Courier'>libapp.so</font>. "
        "Endpoint paths, table names, column lists and the shipped "
        "<font face='Courier'>.env</font> file are therefore directly readable, "
        "which is what this document is built from.", "note"))

    e.append(PageBreak())

    # ---- 2 API surface ----
    e.append(Paragraph("2&nbsp;&nbsp;API surface at a glance", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "The following external services are contacted by one or both apps. "
        "Base URLs are read from the bundled environment file at launch.",
        ss["Body"]))
    e.append(data_table(ss,
        ["Service", "Base URL", "Role", "Used by"],
        [["Supabase", "bjripaytpikgjvroypru.supabase.co",
          "DB / Auth / Realtime / Storage / Functions", "both"],
         ["Admin API (Vercel)", "icaremc-admin.vercel.app",
          "Push, broadcast, Chapa-bank list", "both"],
         ["SMS gateway", "betegna-ai.vercel.app",
          "OTP send / verify", "both"],
         ["Chapa", "api.chapa.co (via SDK)",
          "Payment charge / validate", "patient"],
         ["Firebase FCM", "fcm.googleapis.com",
          "Push token + delivery", "both"],
         ["Google Play", "play.google.com/store/apps/details",
          "Update-prompt version check", "both"]],
        [0.20, 0.34, 0.30, 0.16], mono_cols=(1,)))
    e.append(Spacer(1, 8))
    e.append(Paragraph(
        "Every Supabase interaction is routed through five stable sub-paths that "
        "the client library appends to the base URL:", ss["Body"]))
    e.append(data_table(ss,
        ["Sub-path", "Sub-API", "Purpose"],
        [["/auth/v1", "GoTrue", "Sign-up, sign-in, token refresh, recovery"],
         ["/rest/v1", "PostgREST", "CRUD over Postgres tables &amp; views"],
         ["/rest/v1/rpc/", "PostgREST RPC", "Server-side Postgres functions"],
         ["/realtime/v1", "Realtime", "Websocket subscriptions (chat, presence)"],
         ["/storage/v1", "Storage", "File upload/download (photos, documents)"],
         ["/functions/v1", "Edge Functions", "Deno serverless functions"]],
        [0.22, 0.20, 0.58], mono_cols=(0,)))

    e.append(PageBreak())

    # ---- 3 config / env ----
    e.append(Paragraph("3&nbsp;&nbsp;Runtime configuration &amp; the .env contract",
                       ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Configuration is <b>not</b> hard-coded. Each app bundles a "
        "<font face='Courier'>.env</font> file under "
        "<font face='Courier'>assets/flutter_assets/</font> and loads it at "
        "start-up with the <font face='Courier'>flutter_dotenv</font> package "
        "(<font face='Courier'>package:flutter_dotenv/src/dotenv.dart</font>). "
        "Values feed the Supabase bootstrap and the various API clients.",
        ss["Body"]))
    e.append(Paragraph("Patient app &mdash; shipped .env keys", ss["H3"]))
    e.append(code_block(ss,
        "SUPABASE_URL=https://bjripaytpikgjvroypru.supabase.co\n"
        "SUPABASE_ANON_KEY=<JWT, role=anon>\n"
        "SUPABASE_SERVICE_ROLE_KEY=<JWT, role=service_role>   # see warning\n"
        "PUSH_API_BASE_URL=https://icaremc-admin.vercel.app/\n"
        "SMS_API_BASE_URL=https://betegna-ai.vercel.app\n"
        "IOS_APP_STORE_ID=your_numeric_app_store_id\n"
        "PLAY_STORE_URL=.../details?id=com.icaremc.app\n"
        "MOCK_UPDATE_PROMPT=false\n"
        "ACCESS_TOKEN_SECRET=<JWT>"))
    e.append(Paragraph(
        "The doctor app ships a smaller subset (Supabase URL + anon key, "
        "SMS / push base URLs, and store URLs). The two apps deliberately point "
        "at one shared Supabase project so a doctor and a patient see the same "
        "appointments, messages and profiles.", ss["Body"]))
    e.append(Paragraph("Bootstrap sequence", ss["H3"]))
    e.append(numbered(ss, [
        "<font face='Courier'>main.dart</font> \u2192 "
        "<font face='Courier'>bootstrap.dart</font> loads "
        "<font face='Courier'>.env</font> via dotenv.",
        "Firebase is initialised from "
        "<font face='Courier'>firebase_options.dart</font>.",
        "<font face='Courier'>SupabaseHelper</font> calls "
        "<font face='Courier'>Supabase.initialize(url, anonKey)</font> "
        "&mdash; log line <i>&ldquo;***** Supabase init completed *****&rdquo;</i>.",
        "GetX dependency bindings register the API service/repository "
        "singletons (see the Backend document).",
        "If URL/key are missing the app logs <i>&ldquo;Supabase is not configured. "
        "Add SUPABASE_URL and SUPABASE_ANON_KEY to .env&rdquo;</i> and degrades.",
    ]))
    e.append(callout(ss, "\u26A0  Hard-coded secrets in the shipped bundle",
        ["The patient <font face='Courier'>.env</font> embeds a "
         "<font face='Courier'>SUPABASE_SERVICE_ROLE_KEY</font> and an "
         "<font face='Courier'>ACCESS_TOKEN_SECRET</font>. The service-role key "
         "<b>bypasses all Row-Level-Security</b>; shipping it inside a "
         "distributable APK means anyone who unpacks the app gains full "
         "read/write access to the database.",
         "Recommendation: rotate this key immediately, remove it from client "
         "bundles, and keep service-role usage strictly server-side (Edge "
         "Functions / the Vercel admin API)."], "warn"))

    e.append(PageBreak())

    # ---- 4 supabase api ----
    e.append(Paragraph("4&nbsp;&nbsp;The Supabase API", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Supabase is consumed through the official Dart client stack, whose "
        "sub-packages are all present in the binary: "
        "<font face='Courier'>supabase</font>, "
        "<font face='Courier'>gotrue</font> (auth), "
        "<font face='Courier'>postgrest</font> (REST query builder), "
        "<font face='Courier'>realtime_client</font>, "
        "<font face='Courier'>storage_client</font> and "
        "<font face='Courier'>functions_client</font>. Version banners in the "
        "binary read <i>Supabase v2.12.4</i> / <i>SupabaseClient v2.10.6</i>.",
        ss["Body"]))
    e.append(Paragraph("4.1&nbsp;&nbsp;PostgREST query builder", ss["H2"]))
    e.append(Paragraph(
        "Data access uses the fluent builder "
        "(<font face='Courier'>SupabaseQueryBuilder</font>) which serialises to "
        "PostgREST HTTP calls against <font face='Courier'>/rest/v1/&lt;table&gt;</font>. "
        "Recovered <font face='Courier'>select=</font> strings show embedded "
        "resource expansion (Postgres foreign-key joins), e.g. for a patient&rsquo;s "
        "appointment list:", ss["Body"]))
    e.append(code_block(ss,
        "GET /rest/v1/appointments?select=\n"
        "  *,doctor_profiles(first_name,last_name,specialty,phone,\n"
        "     profile_photo_url),\n"
        "  appointments(appointment_date,time_slot,service_name,\n"
        "     status,payment_status,total_amount)\n"
        "Headers: apikey: <anon>   Authorization: Bearer <user JWT>"))
    e.append(Paragraph("4.2&nbsp;&nbsp;RPC (stored procedures)", ss["H2"]))
    e.append(Paragraph(
        "The <font face='Courier'>/rpc/</font> path is present, indicating "
        "server-side Postgres functions are invoked for transactional logic "
        "(e.g. wallet credit on cancellation, booking finalisation) rather than "
        "doing multi-step writes from the client.", ss["Body"]))
    e.append(Paragraph("4.3&nbsp;&nbsp;Realtime", ss["H2"]))
    e.append(Paragraph(
        "Chat and message tabs subscribe over "
        "<font face='Courier'>/realtime/v1</font> websockets. The binary carries "
        "the guard string <i>&ldquo;Use channel.subscribe() before pushing "
        "events&rdquo;</i>, confirming channel-based subscriptions in "
        "<font face='Courier'>chat_repository.dart</font>.", ss["Body"]))
    e.append(Paragraph("4.4&nbsp;&nbsp;Storage buckets", ss["H2"]))
    e.append(data_table(ss,
        ["Bucket", "Path prefix", "Contents", "App"],
        [["childphotos", "/object/childphotos/", "Child profile photos", "patient"],
         ["documents", "/object/documents/", "Doctor verification docs", "both"],
         ["credentials", "/object/credentials/", "Credential uploads", "both"],
         ["drprofile", "/object/drprofile/", "Doctor profile photos", "doctor"],
         ["drservices", "/object/drservices/", "Service listing images", "doctor"]],
        [0.20, 0.30, 0.34, 0.16], mono_cols=(1,)))
    e.append(Paragraph("4.5&nbsp;&nbsp;Edge Functions", ss["H2"]))
    e.append(Paragraph(
        "The <font face='Courier'>/functions/v1</font> path and the bundled "
        "<font face='Courier'>functions_client</font> package show Deno Edge "
        "Functions are available &mdash; the natural home for privileged operations "
        "that must not run with the anon key on-device.", ss["Body"]))

    e.append(PageBreak())

    # ---- 5 auth ----
    e.append(Paragraph("5&nbsp;&nbsp;Authentication &amp; token lifecycle",
                       ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Authentication is handled by GoTrue through "
        "<font face='Courier'>utils/auth_service.dart</font>. iCare uses a "
        "<b>phone-first</b> model layered on top of Supabase&rsquo;s "
        "email/password primitives.", ss["Body"]))
    e.append(Paragraph("5.1&nbsp;&nbsp;The phone-to-email synthesis trick", ss["H2"]))
    e.append(Paragraph(
        "GoTrue on this project is configured for email/password. To let users "
        "sign in with just a phone number, the client synthesises a deterministic "
        "pseudo-email. The binary reveals the template "
        "<font face='Courier'>&lt;phone&gt;@phone.icare.app</font> and the log "
        "<i>&ldquo;AuthService: phone sign-up unavailable, using email&rdquo;</i>. "
        "So a phone <font face='Courier'>0912345678</font> becomes the login "
        "identity <font face='Courier'>0912345678@phone.icare.app</font> with a "
        "user-chosen password.", ss["Body"]))
    e.append(Paragraph("5.2&nbsp;&nbsp;OTP for verification &amp; recovery", ss["H2"]))
    e.append(Paragraph(
        "Phone ownership and password recovery are proven with SMS OTP issued by "
        "the Betegna gateway (see &sect;6), not by GoTrue&rsquo;s own SMS provider. "
        "The forgot-password flow: request code \u2192 "
        "<font face='Courier'>/sms/send-otp</font> \u2192 user enters code \u2192 "
        "<font face='Courier'>/sms/verify-otp</font> \u2192 client sets a new "
        "password via GoTrue.", ss["Body"]))
    e.append(Paragraph("5.3&nbsp;&nbsp;Tokens &amp; sessions", ss["H2"]))
    e.append(bullets(ss, [
        "GoTrue returns a JWT <b>access token</b> and a <b>refresh token</b>; the "
        "client persists the session and auto-refreshes (the "
        "<font face='Courier'>/token</font> path and gotrue&rsquo;s refresh logic "
        "are present).",
        "Every authenticated REST/Storage call sends "
        "<font face='Courier'>apikey: &lt;anon&gt;</font> plus "
        "<font face='Courier'>Authorization: Bearer &lt;user access token&gt;</font>; "
        "Postgres RLS then scopes rows to <font face='Courier'>auth.uid()</font>.",
        "A <b>guest / demo mode</b> exists "
        "(<font face='Courier'>guest_demo_service.dart</font>) that loads sample "
        "data locally and is <i>not</i> persisted until the user signs in.",
        "Sign-out clears the session through "
        "<font face='Courier'>session_cleanup.dart</font> and hits "
        "<font face='Courier'>/logout</font>.",
    ]))

    e.append(PageBreak())

    # ---- 6 micro apis ----
    e.append(Paragraph("6&nbsp;&nbsp;Companion HTTP micro-APIs", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Beyond Supabase, thin REST clients wrap two Vercel-hosted services. "
        "These are plain <font face='Courier'>package:http</font> JSON calls "
        "built in dedicated client classes.", ss["Body"]))
    e.append(Paragraph("6.1&nbsp;&nbsp;SMS OTP gateway (Betegna AI)", ss["H2"]))
    e.append(Paragraph(
        "Client: <font face='Courier'>core/services/sms_otp_client.dart</font>. "
        "Base URL from <font face='Courier'>SMS_API_BASE_URL</font> (falls back to "
        "the push base URL when empty). An optional "
        "<font face='Courier'>SMS_API_KEY</font> bearer token is supported.",
        ss["Body"]))
    e.append(data_table(ss,
        ["Method", "Endpoint", "Purpose"],
        [["POST", "/sms/send-otp", "Send a one-time code to a phone number"],
         ["POST", "/sms/verify-otp", "Validate the code the user typed"]],
        [0.14, 0.30, 0.56], mono_cols=(1,)))
    e.append(Spacer(1, 6))
    e.append(Paragraph("6.2&nbsp;&nbsp;Admin / push API (icaremc-admin)", ss["H2"]))
    e.append(Paragraph(
        "Clients: <font face='Courier'>push_notify_client.dart</font> and "
        "<font face='Courier'>chapa_banks_service.dart</font>. Base URL from "
        "<font face='Courier'>PUSH_API_BASE_URL</font>.", ss["Body"]))
    e.append(data_table(ss,
        ["Method", "Endpoint", "Purpose", "App"],
        [["POST", "/api/bookings/push", "Notify on booking/appointment events", "patient"],
         ["POST", "/api/chat/push", "Notify the other party of a new message", "both"],
         ["POST", "/api/broadcast", "Broadcast/admin announcements", "both"],
         ["GET", "/api/public/chapa-banks", "List Chapa payout banks", "doctor"]],
        [0.12, 0.30, 0.44, 0.14], mono_cols=(1,)))
    e.append(Spacer(1, 6))
    e.append(Paragraph(
        "The Chapa-banks client logs <i>&ldquo;PUSH_API_BASE_URL not set, using "
        "fallback banks&rdquo;</i>, showing a graceful offline fallback list when "
        "the endpoint is unreachable.", ss["Body"]))

    e.append(PageBreak())

    # ---- 7 chapa ----
    e.append(Paragraph("7&nbsp;&nbsp;Chapa payment API integration", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "The patient app processes appointment payments through <b>Chapa</b> via "
        "the <font face='Courier'>chapasdk</font> Flutter package (bundled under "
        "<font face='Courier'>flutter_assets/packages/chapasdk</font>). "
        "Configuration lives in "
        "<font face='Courier'>core/config/chapa_config.dart</font> and the flow "
        "is orchestrated by "
        "<font face='Courier'>core/services/chapa_payment_service.dart</font>.",
        ss["Body"]))
    e.append(Paragraph("7.1&nbsp;&nbsp;Keys &amp; configuration", ss["H2"]))
    e.append(bullets(ss, [
        "<font face='Courier'>CHAPA_PUBLIC_KEY</font>, "
        "<font face='Courier'>CHAPA_SECRET_KEY</font> and "
        "<font face='Courier'>CHAPA_FEE_PERCENT</font> are referenced.",
        "Keys are <b>not</b> baked into the client&rsquo;s .env &mdash; the app fetches "
        "them from Supabase (<font face='Courier'>payment_settings</font> table via "
        "<font face='Courier'>payment_settings_service.dart</font>). If missing it "
        "shows <i>&ldquo;Chapa is not configured. Add keys in admin payment "
        "settings.&rdquo;</i>",
    ]))
    e.append(Paragraph("7.2&nbsp;&nbsp;Checkout state machine", ss["H2"]))
    e.append(Paragraph(
        "The SDK drives a bloc (<font face='Courier'>ChapaNativeCheckoutBloc</font>) "
        "with explicit states recovered from the binary:", ss["Body"]))
    e.append(data_table(ss,
        ["Endpoint / state", "Meaning"],
        [["POST /inline/charge", "Initiate a direct/inline charge (tx_ref, amount, currency)"],
         ["POST /inline/validate", "Poll/validate the charge result"],
         ["PaymentInitiateApiError", "charge request rejected"],
         ["PaymentValidateSuccessState", "payment confirmed"],
         ["PaymentValidateApiError / NetworkError", "validation or transport failure"]],
        [0.34, 0.66], mono_cols=(0,)))
    e.append(Spacer(1, 6))
    e.append(Paragraph("7.3&nbsp;&nbsp;Wallet &amp; refunds", ss["H2"]))
    e.append(Paragraph(
        "On cancellation the online amount is <i>credited to the patient wallet</i> "
        "(minus non-refundable Chapa gateway fees) rather than reversed on the card "
        "&mdash; e.g. <i>&ldquo;Appointment cancelled. @amount was credited to your "
        "wallet.&rdquo;</i>. Wallet state is served from the "
        "<font face='Courier'>patient_wallets</font> table.", ss["Body"]))

    e.append(PageBreak())

    # ---- 8 FCM ----
    e.append(Paragraph("8&nbsp;&nbsp;Firebase Cloud Messaging channel", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Push delivery uses FCM via <font face='Courier'>firebase_messaging</font>. "
        "The client obtains an FCM registration token and stores it in Supabase; "
        "the binary contains <i>&ldquo;Push: failed to save fcm_token to "
        "Supabase&rdquo;</i>, confirming the token is persisted server-side "
        "(so the admin API can target a device).", ss["Body"]))
    e.append(numbered(ss, [
        "App registers with FCM \u2192 receives a device token.",
        "Token is upserted into Supabase (per-user "
        "<font face='Courier'>fcm_token</font>).",
        "When an event occurs (new message / booking), the app or admin backend "
        "calls the Vercel push endpoints, which look up the target token and ask "
        "FCM (<font face='Courier'>fcm.googleapis.com</font>) to deliver.",
        "On the device, <font face='Courier'>flutter_local_notifications</font> "
        "renders the alert on the <i>&ldquo;ICare notifications&rdquo;</i> channel.",
    ]))
    e.append(callout(ss, "Firebase project identifiers (patient app)",
        "Recovered from <font face='Courier'>firebase_options.dart</font>: "
        "App ID <font face='Courier'>847330343170:android:4b0a00c6&hellip;</font>, "
        "API key <font face='Courier'>AIzaSyBoMFpkMz4&hellip;</font>. These are "
        "client identifiers (normal to ship) but should still be scoped with "
        "Firebase App Check and API-key restrictions.", "note"))

    e.append(PageBreak())

    # ---- 9 request construction ----
    e.append(Paragraph("9&nbsp;&nbsp;Request construction, headers &amp; errors",
                       ss["H1"]))
    e.append(hr())
    e.append(Paragraph("9.1&nbsp;&nbsp;Standard headers", ss["H2"]))
    e.append(code_block(ss,
        "apikey: <SUPABASE_ANON_KEY>\n"
        "Authorization: Bearer <user access token | anon key>\n"
        "Content-Type: application/json\n"
        "X-Supabase-Client-Platform: android\n"
        "X-Supabase-Client-Platform-Version: <os version>\n"
        "Prefer: return=representation      # on inserts/updates"))
    e.append(Paragraph(
        "The two <font face='Courier'>X-Supabase-Client-Platform*</font> headers "
        "are added automatically by the Dart client and are visible in the binary.",
        ss["Body"]))
    e.append(Paragraph("9.2&nbsp;&nbsp;Error handling &amp; resilience", ss["H2"]))
    e.append(bullets(ss, [
        "The <font face='Courier'>retry</font> package is bundled &mdash; transient "
        "network failures are retried with back-off.",
        "Schema drift is detected and surfaced to the user: <i>&ldquo;Cloud "
        "database is missing tables or columns. Ask your admin to run the Supabase "
        "migrations&rdquo;</i>.",
        "Typed exceptions from GoTrue "
        "(<font face='Courier'>AuthWeakPasswordException</font>, etc.) are mapped to "
        "friendly, localised messages in "
        "<font face='Courier'>core/errors/app_errors.dart</font>.",
        "User feedback uses toasts / EasyLoading "
        "(<font face='Courier'>show_toast_dialog.dart</font>, "
        "<font face='Courier'>flutter_easyloading</font>).",
    ]))
    e.append(Paragraph("9.3&nbsp;&nbsp;Model (de)serialisation", ss["H2"]))
    e.append(Paragraph(
        "Rows are mapped to Dart models with named factories such as "
        "<font face='Courier'>ChildRecord.fromSupabaseRow</font> and "
        "<font face='Courier'>ChapaBankOption.fromJson</font>. Column contracts are "
        "explicit in the recovered <font face='Courier'>select=</font> strings, "
        "giving a precise picture of the data shape (see the Backend document).",
        ss["Body"]))

    e.append(PageBreak())

    # ---- 10 security ----
    e.append(Paragraph("10&nbsp;&nbsp;Security observations &amp; recommendations",
                       ss["H1"]))
    e.append(hr())
    e.append(data_table(ss,
        ["#", "Observation", "Risk", "Recommendation"],
        [["1", "service_role JWT shipped in patient .env", "Critical",
          "Rotate now; never ship service_role in a client"],
         ["2", "anon key + endpoints readable in APK", "Expected",
          "Enforce strict RLS on every table; treat anon key as public"],
         ["3", "Synthetic @phone.icare.app identities", "Medium",
          "Ensure phone uniqueness &amp; OTP gate on password reset"],
         ["4", "Chapa keys fetched from DB at runtime", "Low/Good",
          "Keep secret key server-side; only expose public key to client"],
         ["5", "No visible certificate pinning", "Medium",
          "Add TLS pinning for Supabase &amp; payment hosts"],
         ["6", "Firebase API key restrictions unknown", "Low",
          "Enable App Check &amp; restrict the Android API key"]],
        [0.05, 0.34, 0.14, 0.47]))
    e.append(Spacer(1, 10))
    e.append(callout(ss, "Bottom line",
        "The API architecture is a clean, modern &ldquo;BaaS + serverless glue&rdquo; "
        "design: Supabase does the heavy lifting (data, auth, realtime, storage, "
        "edge), while small Vercel functions bridge SMS, push and payment-bank "
        "concerns. The single most important fix is removing the service-role key "
        "from the client bundle and relying on Row-Level Security plus Edge "
        "Functions for anything privileged.", "note"))
    e.append(Spacer(1, 6))
    e.append(Paragraph(
        "See companion documents: <b>Backend Architecture &amp; Data Model</b> "
        "(2/3) and <b>User-Interface Architecture</b> (3/3).", ss["Small"]))

    doc.build(e)
    print("wrote", os.path.abspath(OUT))


if __name__ == "__main__":
    build()
