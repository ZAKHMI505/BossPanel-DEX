#!/data/data/com.termux/files/usr/bin/bash
set -euo pipefail
cd "$(dirname "$0")"
pkg update -y
pkg install -y git curl python zip unzip
echo
echo "GitHub repository URL (create an EMPTY repo first, e.g. https://github.com/USER/BossPanel-DEX.git):"
read -r REPO
echo "GitHub Personal Access Token (repo permission; input hidden):"
read -rs TOKEN
echo
git init
git add .
git -c user.name="BossPanel Builder" -c user.email="builder@users.noreply.github.com" commit -m "Build Boss Panel DEX"
AUTH_REPO="$(printf '%s' "$REPO" | sed "s#https://#https://${TOKEN}@#")"
git branch -M main
git remote remove origin 2>/dev/null || true
git remote add origin "$AUTH_REPO"
git push -u origin main
echo
echo "Upload complete. Open your GitHub repo > Actions > Build Boss Panel DEX."
echo "When the workflow finishes, download the Boss_Panel_Dialog_HOOK artifact."
