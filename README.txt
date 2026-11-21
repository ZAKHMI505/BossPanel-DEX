BOSS PANEL PREMIUM - EXACT HTML DEX BUILD KIT

BossPanel.html is copied verbatim from the HTML supplied in the conversation.
No HTML/CSS/JavaScript edits are applied by the build scripts. scripts/embed_html.py
Base64-embeds those exact bytes into the Java WebView wrapper at build time.

ONE COMMAND (after extracting this ZIP in Termux):
  bash one-command.sh

Before running, create an EMPTY GitHub repository and enable Actions. The script
asks for its HTTPS URL and a GitHub Personal Access Token with repository write
permission. It pushes the project; GitHub Actions compiles the Java wrapper with
Android D8 and produces an artifact ZIP containing ONLY:
  classes2.dex
  HOOK .txt

Important:
- This build kit is source/build automation; compiled DEX is produced by GitHub Actions.
- Target package/MainActivity hook is based on inspection of GalaxyCrash_1.17.apk.
- Original classes.dex is not modified.
- Host app must have INTERNET permission for Firebase/CDN assets to load.
- Test on a backup APK first. DEX insertion and signing are performed separately in MT Manager.
- HTML behavior remains exactly as supplied; for example, the existing closeDialog/crashApp
  JavaScript behavior is preserved as-is.
