BOSS PANEL - TRANSPARENT DIALOG OVERLAY DEX BUILD KIT

This revision keeps the supplied Boss Panel dialog card styling/content and removes
the full-page pastel background and decorative background blobs. The Android app
behind the dialog remains visible through the transparent WebView/Dialog window.

Behavior:
- Access-key dialog is shown as an overlay above the existing app.
- Closing the access dialog dismisses the native overlay so the host app is usable.
- If Firebase config enables forceUpdate, the update dialog is shown.
- Tapping LATER safely dismisses the overlay and closes the host app task (returns
  to the launcher/home screen). It does not deliberately crash the process.

The HTML is embedded verbatim by scripts/embed_html.py after the two requested
background/exit behavior changes. Other dialog styles, Firebase settings, and
dialog content are retained.

GitHub Actions builds classes2.dex and creates an artifact ZIP containing only:
  classes2.dex
  HOOK .txt

For the existing Termux checkout, replace the project files with this kit, then:
  git add .
  git commit -m "Make Boss Panel dialog transparent overlay"
  git push

Open GitHub > Actions and download the Boss_Panel_Dialog_HOOK artifact after the
workflow succeeds. This source kit itself is not a compiled DEX.
