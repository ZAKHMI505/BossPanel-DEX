#!/data/data/com.termux/files/usr/bin/bash
set -euo pipefail
cd "$(dirname "$0")"
pkg update -y
pkg install -y openjdk-17 git curl python zip unzip
python scripts/embed_html.py
echo "This source project is built by GitHub Actions (Android SDK/D8)."
