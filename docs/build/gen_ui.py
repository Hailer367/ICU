#!/usr/bin/env python3
"""Generate: iCare MC - User-Interface Architecture (PDF 3 of 3)."""
import os
from reportlab.platypus import Spacer, Paragraph, PageBreak, NextPageTemplate
import pdf_kit
from pdf_kit import (styles, DocTemplate, hr, bullets, numbered, code_block,
                     data_table, callout, cover)

OUT = os.path.join(os.path.dirname(__file__), "..", "..",
                   "iCareMC_UI_Architecture.pdf")


def build():
    ss = styles()
    doc = DocTemplate(OUT, "iCare MC \u2014 User-Interface Architecture",
                      "User-Interface Architecture \u2014 3 / 3")
    e = []

    e += cover(
        ss, "TECHNICAL ARCHITECTURE  \u2022  DOC 3 / 3",
        ["User-Interface", "Architecture"],
        "The Flutter presentation layer of both iCare MC apps: the GetX "
        "pattern, navigation, module structure, theming, localisation and "
        "reusable widgets.",
        [("Subject", "Patient app (icare_mc) &amp; Doctor app (icare_doctors)"),
         ("UI toolkit", "Flutter (Material 3) compiled to AOT libapp.so"),
         ("State mgmt", "GetX \u2014 controllers, bindings, reactive Obx"),
         ("Navigation", "GetX named routes (GetPage / GetMaterialApp)"),
         ("i18n", "English, Amharic (\u12A0\u121B\u122D\u129B), Afaan Oromoo"),
         ("Method", "Module/route/widget map recovered from AOT metadata")],
    )
    e.append(NextPageTemplate("Content"))
    e.append(PageBreak())

    # TOC
    e.append(Paragraph("Contents", ss["H1"]))
    e.append(hr(pdf_kit.BRAND))
    for n, t in [
        ("1", "UI stack overview"),
        ("2", "The GetX architecture (MVC + reactive)"),
        ("3", "Navigation &amp; routing"),
        ("4", "App shell &amp; tab structure"),
        ("5", "Patient app module map"),
        ("6", "Doctor app module map"),
        ("7", "Reusable widget library"),
        ("8", "Theming &amp; design system"),
        ("9", "Localisation &amp; accessibility"),
        ("10", "UX patterns, feedback &amp; native surfaces"),
    ]:
        e.append(data_table(ss, ["", ""], [[n, t]], [0.08, 0.92]))
        e.append(Spacer(1, 1))
    e.append(PageBreak())

    # 1 overview
    e.append(Paragraph("1&nbsp;&nbsp;UI stack overview", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Both apps are single-<font face='Courier'>Activity</font> Flutter apps. "
        "The patient app hosts Flutter through a custom "
        "<font face='Courier'>FlutterActivity</font> variant, while the doctor "
        "app extends the stock "
        "<font face='Courier'>io.flutter.embedding.android.FlutterActivity</font>. "
        "All screens, layout, animation and interaction are drawn by the Flutter "
        "engine (<font face='Courier'>libflutter.so</font>) executing the app&rsquo;s "
        "compiled Dart (<font face='Courier'>libapp.so</font>). There are no "
        "Android XML layouts for the product UI &mdash; only Flutter widgets.",
        ss["Body"]))
    e.append(Paragraph("Key UI technologies (from bundled Dart packages)", ss["H3"]))
    e.append(data_table(ss,
        ["Package", "Role in the UI"],
        [["get (GetX)", "State management, DI, and named-route navigation"],
         ["Material 3", "Base widget set &amp; theming (ColorScheme, Material)"],
         ["flutter_easyloading", "Global loading / toast overlays"],
         ["fluttertoast", "Lightweight toast messages (patient)"],
         ["pinput / otp_pin_field", "OTP entry UI"],
         ["country_code_picker", "Phone country selector (doctor)"],
         ["image_picker", "Camera/gallery for photos &amp; documents"],
         ["flutter_inappwebview", "Embedded web content (patient)"],
         ["youtube_player_iframe", "In-app educational video playback (patient)"],
         ["chapasdk", "Native Chapa checkout screens (patient)"],
         ["cupertino_icons", "iOS-style iconography (doctor)"]],
        [0.26, 0.74], mono_cols=(0,)))
    e.append(PageBreak())

    # 2 GetX
    e.append(Paragraph("2&nbsp;&nbsp;The GetX architecture (MVC + reactive)", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Both apps follow the canonical <b>GetX pattern</b>, visible directly in "
        "the folder layout: every feature is a <i>module</i> split into "
        "<font face='Courier'>bindings/</font>, "
        "<font face='Courier'>controllers/</font> and "
        "<font face='Courier'>views/</font> (plus <font face='Courier'>widgets/</font>).",
        ss["Body"]))
    e.append(data_table(ss,
        ["Layer", "GetX type", "Responsibility"],
        [["View", "GetView / StatelessWidget",
          "Declarative UI; rebuilds reactively via Obx/GetX"],
         ["Controller", "GetxController",
          "Screen state as reactive .obs fields; calls services/repos"],
         ["Binding", "Bindings",
          "Lazily registers the controller + deps when a route opens"],
         ["Service/Repo", "Get.put/lazyPut singletons",
          "API access (Supabase, HTTP), business logic"]],
        [0.16, 0.24, 0.60]))
    e.append(Spacer(1, 6))
    e.append(Paragraph(
        "Reactivity uses observable fields and <font face='Courier'>Obx()</font> "
        "widgets &mdash; when a controller mutates an <font face='Courier'>.obs</font> "
        "value, only the wrapping <font face='Courier'>Obx</font> rebuilds. "
        "Dependency injection is handled by GetX bindings attached to each route, "
        "so a controller is created on navigation and disposed automatically when "
        "the route leaves the stack.", ss["Body"]))
    e.append(code_block(ss,
        "modules/dr_tab/\n"
        "  bindings/doctor_booking_binding.dart     <- registers controller\n"
        "  controllers/doctor_booking_controller.dart <- reactive state + logic\n"
        "  views/doctor_booking_page.dart           <- Obx-driven UI\n"
        "  widgets/dr_booking_card.dart             <- reusable sub-widgets"))
    e.append(callout(ss, "Consistent, testable structure",
        "The strict bindings/controllers/views triad repeats across ~15 patient "
        "modules and ~14 doctor modules. This makes the codebase highly uniform: "
        "each screen is self-contained and its dependencies are declared in one "
        "place.", "note"))
    e.append(PageBreak())

    # 3 navigation
    e.append(Paragraph("3&nbsp;&nbsp;Navigation &amp; routing", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "The root widget is a <font face='Courier'>GetMaterialApp</font>. Routes "
        "are declared centrally in "
        "<font face='Courier'>app/routes/app_pages.dart</font> as "
        "<font face='Courier'>GetPage</font> entries, each pairing a path, a view "
        "and a binding. Navigation is imperative and string-named "
        "(<font face='Courier'>Get.toNamed('/doctor-booking')</font>), wrapped by "
        "<font face='Courier'>core/utils/app_nav.dart</font>.", ss["Body"]))
    e.append(Paragraph("Recovered route names", ss["H3"]))
    e.append(data_table(ss,
        ["Patient app routes", "Doctor app routes"],
        [["/splash, /onboarding, /introduction", "/splash, /sign-up, /login"],
         ["/login, /sign-up, /forgot-password", "/forgot-password, /main"],
         ["/main (tab shell)", "/dashboard (tab), /appointments"],
         ["/profile, /edit-profile, /settings", "/messages, /chat"],
         ["/settings-baby / -language / -theme / -notifications", "/availability"],
         ["/health-tracker", "/booking-services, /add-service"],
         ["/doctor-detail, /doctor-service-detail", "/service-reviews"],
         ["/doctor-booking, /doctor-chat", "/bank-details, /wallet-history"],
         ["/my-appointments, /my-messages", "/payment-history"],
         ["/rating-screen", "/personal-details, /verify-documents"]],
        [0.5, 0.5], mono_cols=(0, 1)))
    e.append(Spacer(1, 6))
    e.append(Paragraph(
        "Deep-link handling is present via the <font face='Courier'>app_links</font> "
        "package (doctor app), allowing external URLs (e.g. payment returns) to "
        "route into the app.", ss["Body"]))
    e.append(PageBreak())

    # 4 shell
    e.append(Paragraph("4&nbsp;&nbsp;App shell &amp; tab structure", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "After authentication the user lands on a persistent <b>tab shell</b> "
        "(<font face='Courier'>main/views/main_shell_view.dart</font> driven by "
        "<font face='Courier'>main_shell_controller.dart</font>). The shell hosts "
        "a bottom navigation bar and swaps tab views while keeping their state "
        "alive.", ss["Body"]))
    e.append(Paragraph("Patient bottom tabs (from *_tab_view.dart)", ss["H3"]))
    e.append(bullets(ss, [
        "<b>Home</b> &mdash; daily greeting, tips, quick actions "
        "(<font face='Courier'>home_tab_view.dart</font>).",
        "<b>Baby / Child</b> &mdash; growth, milestones, vaccines "
        "(<font face='Courier'>baby_tab</font>, "
        "<font face='Courier'>child_tab</font>, "
        "<font face='Courier'>baby_growth</font>).",
        "<b>Pregnancy / Tools</b> &mdash; week-by-week content and calculators "
        "(<font face='Courier'>pregnancy_tab</font>, "
        "<font face='Courier'>pregnancy_dates</font>).",
        "<b>Doctors</b> &mdash; browse, book, chat, appointments "
        "(<font face='Courier'>dr_tab</font>).",
        "<b>Health tracker</b> &mdash; measurements &amp; follow-ups "
        "(<font face='Courier'>health_tab</font>, "
        "<font face='Courier'>followup</font>).",
        "<b>Profile</b> &mdash; account, wallet, settings.",
    ]))
    e.append(Paragraph("Doctor bottom tabs", ss["H3"]))
    e.append(bullets(ss, [
        "<b>Dashboard</b> &mdash; KPIs, monthly revenue chart, insights "
        "(<font face='Courier'>dashboard</font>, "
        "<font face='Courier'>monthly_revenue_chart.dart</font>).",
        "<b>Appointments</b> &mdash; upcoming/past bookings.",
        "<b>Messages</b> &mdash; patient conversations "
        "(<font face='Courier'>messages</font>, <font face='Courier'>chat</font>).",
        "<b>Payment history / Wallet</b> &mdash; earnings &amp; payouts.",
        "<b>Profile</b> &mdash; personal details, verification, services, "
        "availability, bank details, settings.",
    ]))
    e.append(callout(ss, "Child-profile gate",
        "The patient app guards child-specific tabs behind a "
        "<font face='Courier'>child_profile_gate.dart</font> / "
        "<font face='Courier'>baby_profile_setup.dart</font> flow: until a child "
        "(or pregnancy) is recorded, the relevant tabs prompt the user to set one "
        "up.", "note"))
    e.append(PageBreak())

    # 5 patient module map
    e.append(Paragraph("5&nbsp;&nbsp;Patient app module map", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Every module under "
        "<font face='Courier'>icare_mc/app/modules/</font> and its purpose:",
        ss["Body"]))
    e.append(data_table(ss,
        ["Module", "Screens / purpose"],
        [["splash / onboarding / introduction", "Launch, first-run walkthrough, about"],
         ["login / sign_up / forgot_password", "Phone-based auth &amp; recovery"],
         ["main", "Bottom-tab shell container"],
         ["home", "Personalised dashboard &amp; daily tips"],
         ["baby_tab / child_tab / baby_growth", "Child profile &amp; growth charts"],
         ["development", "Milestones, learning path, add-measurement sheets"],
         ["health_tab", "Health tracker page &amp; entry sheets"],
         ["followup", "Follow-up visits, vaccine alerts &amp; banners"],
         ["pregnancy_tab / pregnancy_week", "Week-by-week pregnancy experience"],
         ["pregnancy_dates", "Due-date &amp; pregnancy calculators/tools"],
         ["dr_tab", "Doctor browse, detail, service, booking, chat, ratings"],
         ["profile / settings", "Account, wallet, language/theme/notifications"],
         ["legal", "Terms &amp; privacy viewer"]],
        [0.30, 0.70], mono_cols=(0,)))
    e.append(PageBreak())

    # 6 doctor module map
    e.append(Paragraph("6&nbsp;&nbsp;Doctor app module map", ss["H1"]))
    e.append(hr())
    e.append(data_table(ss,
        ["Module", "Screens / purpose"],
        [["splash / login / sign_up / forgot_password", "Launch &amp; auth"],
         ["main", "Bottom-tab shell"],
         ["dashboard", "Revenue KPIs, insights, monthly chart"],
         ["appointments", "Manage patient appointments"],
         ["messages / chat", "Conversations with patients"],
         ["booking_services", "Create/manage services; add-service; reviews"],
         ["availability", "Set bookable time slots"],
         ["payment_history", "Completed transactions"],
         ["wallet_history", "Wallet ledger &amp; payout tracking"],
         ["bank_details", "Chapa payout bank setup"],
         ["profile", "Personal details &amp; document verification"],
         ["settings", "Theme, language, notifications"],
         ["legal", "Terms &amp; privacy viewer"]],
        [0.32, 0.68], mono_cols=(0,)))
    e.append(Spacer(1, 8))
    e.append(Paragraph(
        "The doctor app adds finance-oriented UI (revenue chart, payout status, "
        "wallet history) and a credential-upload flow "
        "(<font face='Courier'>credential_image_picker.dart</font>, "
        "<font face='Courier'>verify_documents_view.dart</font>) that the patient "
        "app does not have.", ss["Body"]))
    e.append(PageBreak())

    # 7 widget library
    e.append(Paragraph("7&nbsp;&nbsp;Reusable widget library", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Both apps ship a shared <font face='Courier'>app/widgets/</font> folder "
        "of composable UI building blocks, giving a consistent look across "
        "screens.", ss["Body"]))
    e.append(Paragraph("Shared / common widgets", ss["H3"]))
    e.append(bullets(ss, [
        "<font face='Courier'>primary_button</font>, "
        "<font face='Courier'>app_card</font>, "
        "<font face='Courier'>section_header</font>, "
        "<font face='Courier'>common_app_bar</font> &mdash; layout primitives.",
        "<font face='Courier'>app_text_field</font>, "
        "<font face='Courier'>phone_auth_field</font>, "
        "<font face='Courier'>otp_pin_field</font>, "
        "<font face='Courier'>date_picker_field</font> &mdash; form inputs "
        "(validated by <font face='Courier'>form_validators.dart</font>).",
        "<font face='Courier'>doctor_avatar</font>, "
        "<font face='Courier'>app_logo</font>, "
        "<font face='Courier'>daily_greeting_banner</font> &mdash; branded "
        "elements.",
        "<font face='Courier'>app_update_modal</font> &mdash; force/optional "
        "update prompt driven by the version-policy service.",
        "<font face='Courier'>chat/chat_widgets</font> &mdash; message bubbles / "
        "conversation tiles shared by chat screens.",
    ]))
    e.append(Paragraph("Patient-specific widgets", ss["H3"]))
    e.append(bullets(ss, [
        "<font face='Courier'>child_avatar</font>, "
        "<font face='Courier'>child_birth_form_fields</font>, "
        "<font face='Courier'>record_birth_sheet</font>, "
        "<font face='Courier'>baby_profile_setup</font>.",
        "<font face='Courier'>milestone_media_view</font>, "
        "<font face='Courier'>pregnancy_week_hero_image</font>, "
        "<font face='Courier'>tool_grid_card</font>, "
        "<font face='Courier'>result_banner</font>.",
        "<font face='Courier'>gateway_payment_summary_card</font>, "
        "<font face='Courier'>guest_demo_banner</font>, "
        "<font face='Courier'>method_selector</font>.",
    ]))
    e.append(Paragraph("Doctor-specific widgets", ss["H3"]))
    e.append(bullets(ss, [
        "<font face='Courier'>stat_card</font>, "
        "<font face='Courier'>monthly_revenue_chart</font> &mdash; dashboard "
        "analytics.",
        "<font face='Courier'>searchable_hospital_field</font>, "
        "<font face='Courier'>credential_image_picker</font>, "
        "<font face='Courier'>phone_link</font>, "
        "<font face='Courier'>profile_setting_widgets</font>.",
    ]))
    e.append(PageBreak())

    # 8 theming
    e.append(Paragraph("8&nbsp;&nbsp;Theming &amp; design system", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "Theming is centralised in "
        "<font face='Courier'>themes/light_theme.dart</font> and "
        "<font face='Courier'>themes/dark_theme.dart</font>, coordinated by "
        "<font face='Courier'>core/theme/app_theme_controller.dart</font>. The "
        "controller toggles <font face='Courier'>ThemeMode</font> "
        "(light / dark / system) via GetX "
        "(<font face='Courier'>Get.changeThemeMode</font>) and persists the "
        "choice in local preferences.", ss["Body"]))
    e.append(bullets(ss, [
        "<b>Material 3</b> <font face='Courier'>ColorScheme</font>-based theming "
        "&mdash; the full Material 3 component theme set is present in the binary "
        "(app bar, cards, chips, dialogs, navigation bar, etc.).",
        "<b>Brand</b> assets: <font face='Courier'>app_branding.dart</font>, plus "
        "bundled <font face='Courier'>logo.png</font> / "
        "<font face='Courier'>logo_icon.png</font>.",
        "<b>Typography</b> via the default Material font with "
        "<font face='Courier'>MaterialIcons</font> icon font bundled in "
        "<font face='Courier'>FontManifest.json</font>.",
        "<b>User-selectable theme</b> exposed on the "
        "<font face='Courier'>settings-theme</font> screen.",
    ]))
    e.append(callout(ss, "System-driven surfaces",
        "The app also sets Android system UI (status/navigation bar) via Flutter "
        "<font face='Courier'>SystemChrome</font>, and supports predictive-back "
        "gestures (Material predictive-back transitions are compiled in), aligning "
        "with modern Android 14+ behaviour (target SDK 36).", "note"))
    e.append(PageBreak())

    # 9 localisation
    e.append(Paragraph("9&nbsp;&nbsp;Localisation &amp; accessibility", ss["H1"]))
    e.append(hr())
    e.append(Paragraph(
        "The apps are fully trilingual, a core requirement for the Ethiopian "
        "market. Locale is managed by "
        "<font face='Courier'>core/locale/app_locale_controller.dart</font> with "
        "strings in <font face='Courier'>core/locale/app_strings.dart</font> and a "
        "<font face='Courier'>services/localization_service.dart</font>.", ss["Body"]))
    e.append(data_table(ss,
        ["Language", "In-app label", "Notes"],
        [["English", "English", "Default / fallback"],
         ["Amharic", "\u12A0\u121B\u122D\u129B", "Full UI + content translations"],
         ["Afaan Oromoo", "Afaan Oromoo", "Full UI + content translations"]],
        [0.28, 0.30, 0.42]))
    e.append(Spacer(1, 6))
    e.append(bullets(ss, [
        "UI strings switch instantly through GetX "
        "(<font face='Courier'>Get.updateLocale</font>); the choice is persisted "
        "and selectable on <font face='Courier'>settings-language</font>.",
        "<b>Content</b> (pregnancy weeks, tips, growth periods) is localised "
        "server-side via <font face='Courier'>*_translations</font> tables keyed "
        "by <font face='Courier'>language_code</font> and merged by "
        "<font face='Courier'>content_translation_service.dart</font>.",
        "Flutter <font face='Courier'>Semantics</font> and Material localisation "
        "delegates are present, providing baseline screen-reader support and "
        "locale-correct dates/number formatting "
        "(<font face='Courier'>date_format_utils.dart</font>).",
    ]))
    e.append(PageBreak())

    # 10 UX patterns
    e.append(Paragraph("10&nbsp;&nbsp;UX patterns, feedback &amp; native surfaces",
                       ss["H1"]))
    e.append(hr())
    e.append(Paragraph("10.1&nbsp;&nbsp;Feedback &amp; loading", ss["H2"]))
    e.append(bullets(ss, [
        "Global spinners/overlays via <font face='Courier'>flutter_easyloading</font>; "
        "toasts via <font face='Courier'>show_toast_dialog.dart</font> "
        "(<font face='Courier'>fluttertoast</font> on patient).",
        "Bottom sheets are used heavily for quick input (add-measurement, "
        "record-birth, health-tracker, learning-path sheets).",
        "Confirmation dialogs for destructive/financial actions (e.g. appointment "
        "cancellation with wallet-refund explanation).",
    ]))
    e.append(Paragraph("10.2&nbsp;&nbsp;Native / embedded surfaces", ss["H2"]))
    e.append(bullets(ss, [
        "<b>Chapa checkout</b> renders the SDK&rsquo;s native payment screens "
        "inside the patient flow.",
        "<b>YouTube playback</b> for educational content via "
        "<font face='Courier'>youtube_player_iframe</font> "
        "(<font face='Courier'>youtube_utils.dart</font>).",
        "<b>In-app webview</b> (<font face='Courier'>flutter_inappwebview</font>) "
        "for web content / legal pages.",
        "<b>Image capture</b> (<font face='Courier'>image_picker</font>) for child "
        "photos and doctor credential uploads.",
        "<b>Push notifications</b> surfaced through "
        "<font face='Courier'>flutter_local_notifications</font> on the "
        "&lsquo;ICare notifications&rsquo; channel.",
    ]))
    e.append(Paragraph("10.3&nbsp;&nbsp;App-update UX", ss["H2"]))
    e.append(Paragraph(
        "An <font face='Courier'>app_update_service.dart</font> + "
        "<font face='Courier'>app_version_policy_service.dart</font> compares the "
        "installed version against a server policy and against the store listing "
        "(Play Store URL, or <font face='Courier'>in_app_update</font> on the "
        "doctor app) to show an <font face='Courier'>app_update_modal</font> "
        "(optional or forced). A <font face='Courier'>MOCK_UPDATE_PROMPT</font> "
        "flag exists for QA.", ss["Body"]))
    e.append(Spacer(1, 8))
    e.append(callout(ss, "Summary",
        "The UI is a clean, uniform Flutter + GetX application: centralised "
        "named-route navigation, a per-feature bindings/controllers/views triad, a "
        "shared Material-3 design system with light/dark theming, trilingual "
        "localisation, and a rich reusable widget library. The patient app "
        "emphasises child-health and pregnancy journeys plus doctor booking, while "
        "the doctor app emphasises scheduling, messaging and finance. Native "
        "surfaces (Chapa, YouTube, webview, camera, notifications) are integrated "
        "through well-scoped Flutter plugins.", "note"))
    e.append(Spacer(1, 6))
    e.append(Paragraph(
        "See companion documents: <b>API Architecture &amp; Configuration</b> "
        "(1/3) and <b>Backend Architecture &amp; Data Model</b> (2/3).", ss["Small"]))

    doc.build(e)
    print("wrote", os.path.abspath(OUT))


if __name__ == "__main__":
    build()
