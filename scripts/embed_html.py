from pathlib import Path
import base64
p = Path("BossPanel.html")
java = Path("src/com/bosspanel/dialog/BossPanelDialog.java")
encoded = base64.b64encode(p.read_bytes()).decode("ascii")
s = java.read_text(encoding="utf-8")
s = s.replace("HTML_B64_PLACEHOLDER", encoded)
java.write_text(s, encoding="utf-8")
print("Embedded original BossPanel.html bytes:", p.stat().st_size)
