"""
Shared PDF building toolkit for the iCare MC architecture documentation set.

Provides a light, professional theme built on ReportLab Platypus so the three
architecture PDFs (API, Backend, UI) share consistent typography, colors,
headers/footers, cover pages, tables, code blocks and callout boxes.
"""

from reportlab.lib import colors
from reportlab.lib.enums import TA_CENTER, TA_LEFT, TA_JUSTIFY
from reportlab.lib.pagesizes import A4
from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
from reportlab.lib.units import cm, mm
from reportlab.platypus import (
    BaseDocTemplate, PageTemplate, Frame, Paragraph, Spacer, Table, TableStyle,
    NextPageTemplate, PageBreak, HRFlowable, ListFlowable, ListItem, KeepTogether,
)

# ---------------------------------------------------------------------------
# Palette  (iCare = maternal / child health -> teal + coral accents)
# ---------------------------------------------------------------------------
BRAND        = colors.HexColor("#0F6E76")   # deep teal
BRAND_DARK   = colors.HexColor("#0A4C52")
BRAND_LIGHT  = colors.HexColor("#E3F1F2")
ACCENT       = colors.HexColor("#E8734A")   # coral
INK          = colors.HexColor("#1F2933")
MUTED        = colors.HexColor("#5B6B78")
RULE         = colors.HexColor("#C9D6DC")
CODE_BG      = colors.HexColor("#0E2A2E")
CODE_FG      = colors.HexColor("#DCEFEF")
TABLE_HEAD   = BRAND
TABLE_ALT    = colors.HexColor("#F2F8F8")
WARN_BG      = colors.HexColor("#FDECE4")
WARN_BR      = ACCENT
NOTE_BG      = colors.HexColor("#EAF3FB")
NOTE_BR      = colors.HexColor("#2F80C9")

PAGE_W, PAGE_H = A4
LM = RM = 2.0 * cm
TM = 2.3 * cm
BM = 1.9 * cm


def styles():
    ss = getSampleStyleSheet()

    def add(name, **kw):
        ss.add(ParagraphStyle(name, **kw))

    add("CoverTitle", fontName="Helvetica-Bold", fontSize=30, leading=35,
        textColor=colors.white, alignment=TA_LEFT)
    add("CoverSub", fontName="Helvetica", fontSize=14, leading=19,
        textColor=BRAND_LIGHT, alignment=TA_LEFT)
    add("CoverMeta", fontName="Helvetica", fontSize=9.5, leading=15,
        textColor=colors.white, alignment=TA_LEFT)

    add("H1", fontName="Helvetica-Bold", fontSize=18, leading=22,
        textColor=BRAND_DARK, spaceBefore=6, spaceAfter=8)
    add("H2", fontName="Helvetica-Bold", fontSize=13.5, leading=17,
        textColor=BRAND, spaceBefore=12, spaceAfter=5)
    add("H3", fontName="Helvetica-Bold", fontSize=11.5, leading=15,
        textColor=INK, spaceBefore=9, spaceAfter=3)
    add("Body", fontName="Helvetica", fontSize=9.7, leading=14.5,
        textColor=INK, alignment=TA_JUSTIFY, spaceAfter=6)
    add("BodyL", fontName="Helvetica", fontSize=9.7, leading=14.5,
        textColor=INK, alignment=TA_LEFT, spaceAfter=6)
    add("UL", fontName="Helvetica", fontSize=9.7, leading=14,
        textColor=INK, alignment=TA_LEFT)
    add("Small", fontName="Helvetica", fontSize=8.3, leading=11.5,
        textColor=MUTED)
    add("Caption", fontName="Helvetica-Oblique", fontSize=8.3, leading=11.5,
        textColor=MUTED, spaceAfter=8)
    add("Mono", fontName="Courier", fontSize=8.2, leading=11.6,
        textColor=CODE_FG)
    add("TblH", fontName="Helvetica-Bold", fontSize=8.7, leading=11,
        textColor=colors.white)
    add("Tbl", fontName="Helvetica", fontSize=8.6, leading=11.5,
        textColor=INK)
    add("TblMono", fontName="Courier", fontSize=8.2, leading=11.2,
        textColor=INK)
    add("Callout", fontName="Helvetica", fontSize=9.2, leading=13.5,
        textColor=INK)
    add("CalloutH", fontName="Helvetica-Bold", fontSize=9.3, leading=13,
        textColor=BRAND_DARK)
    add("TOCItem", fontName="Helvetica", fontSize=10.5, leading=20,
        textColor=INK)
    add("TOCNum", fontName="Helvetica-Bold", fontSize=10.5, leading=20,
        textColor=BRAND)
    return ss


class DocTemplate(BaseDocTemplate):
    """Two page templates: a full-bleed cover and the normal content page."""

    def __init__(self, filename, title, doc_tag, **kw):
        super().__init__(filename, pagesize=A4,
                         leftMargin=LM, rightMargin=RM,
                         topMargin=TM, bottomMargin=BM,
                         title=title, author="iCare MC Reverse-Engineering",
                         **kw)
        self.doc_title = title
        self.doc_tag = doc_tag

        cover_frame = Frame(0, 0, PAGE_W, PAGE_H, id="cover",
                            leftPadding=0, rightPadding=0,
                            topPadding=0, bottomPadding=0)
        content_frame = Frame(LM, BM, PAGE_W - LM - RM, PAGE_H - TM - BM,
                              id="content")
        self.addPageTemplates([
            PageTemplate(id="Cover", frames=[cover_frame],
                         onPage=self._cover_bg),
            PageTemplate(id="Content", frames=[content_frame],
                         onPage=self._decorate),
        ])

    def _cover_bg(self, canvas, doc):
        canvas.saveState()
        canvas.setFillColor(BRAND_DARK)
        canvas.rect(0, 0, PAGE_W, PAGE_H, stroke=0, fill=1)
        canvas.setFillColor(BRAND)
        canvas.rect(0, PAGE_H * 0.52, PAGE_W, PAGE_H * 0.48, stroke=0, fill=1)
        # accent bars
        canvas.setFillColor(ACCENT)
        canvas.rect(LM, PAGE_H * 0.50, 5.5 * cm, 5, stroke=0, fill=1)
        # decorative dotted grid
        canvas.setFillColor(colors.Color(1, 1, 1, alpha=0.06))
        for gx in range(0, int(PAGE_W), 22):
            for gy in range(0, int(PAGE_H * 0.5), 22):
                canvas.circle(gx, gy, 1.1, stroke=0, fill=1)
        canvas.restoreState()

    def _decorate(self, canvas, doc):
        canvas.saveState()
        # header
        canvas.setStrokeColor(RULE)
        canvas.setLineWidth(0.5)
        canvas.line(LM, PAGE_H - TM + 0.55 * cm, PAGE_W - RM, PAGE_H - TM + 0.55 * cm)
        canvas.setFont("Helvetica-Bold", 7.5)
        canvas.setFillColor(BRAND)
        canvas.drawString(LM, PAGE_H - TM + 0.75 * cm, "iCare MC")
        canvas.setFont("Helvetica", 7.5)
        canvas.setFillColor(MUTED)
        canvas.drawRightString(PAGE_W - RM, PAGE_H - TM + 0.75 * cm, self.doc_tag)
        # footer
        canvas.setStrokeColor(RULE)
        canvas.line(LM, BM - 0.35 * cm, PAGE_W - RM, BM - 0.35 * cm)
        canvas.setFont("Helvetica", 7.5)
        canvas.setFillColor(MUTED)
        canvas.drawString(LM, BM - 0.75 * cm,
                          "Reverse-engineered from release APKs \u2022 confidential")
        canvas.drawRightString(PAGE_W - RM, BM - 0.75 * cm, "Page %d" % doc.page)
        canvas.restoreState()


# ---------------------------------------------------------------------------
# Flowable helpers
# ---------------------------------------------------------------------------

def hr(color=RULE, w=0.6, sb=2, sa=8):
    return HRFlowable(width="100%", thickness=w, color=color,
                      spaceBefore=sb, spaceAfter=sa)


def bullets(ss, items, style="UL", lead="\u2022"):
    return ListFlowable(
        [ListItem(Paragraph(t, ss[style]), leftIndent=10, value=lead)
         for t in items],
        bulletType="bullet", start=lead, leftIndent=14,
        bulletFontName="Helvetica", bulletColor=ACCENT, spaceAfter=6,
    )


def numbered(ss, items, style="UL"):
    return ListFlowable(
        [ListItem(Paragraph(t, ss[style]), leftIndent=10) for t in items],
        bulletType="1", leftIndent=16, bulletColor=BRAND,
        bulletFontName="Helvetica-Bold", spaceAfter=6,
    )


def code_block(ss, text):
    rows = [[Paragraph(_esc_code(line), ss["Mono"])] for line in text.split("\n")]
    t = Table(rows, colWidths=[PAGE_W - LM - RM])
    t.setStyle(TableStyle([
        ("BACKGROUND", (0, 0), (-1, -1), CODE_BG),
        ("LEFTPADDING", (0, 0), (-1, -1), 10),
        ("RIGHTPADDING", (0, 0), (-1, -1), 10),
        ("TOPPADDING", (0, 0), (0, 0), 8),
        ("BOTTOMPADDING", (0, -1), (0, -1), 8),
        ("TOPPADDING", (0, 1), (-1, -1), 0.5),
        ("BOTTOMPADDING", (0, 0), (-1, -2), 0.5),
        ("LINEBEFORE", (0, 0), (0, -1), 3, ACCENT),
    ]))
    return t


def _esc_code(s):
    return (s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
             .replace(" ", "&nbsp;"))


def data_table(ss, header, rows, col_widths, mono_cols=()):
    avail = PAGE_W - LM - RM
    cw = [avail * w for w in col_widths]
    data = [[Paragraph(h, ss["TblH"]) for h in header]]
    for r in rows:
        cells = []
        for ci, c in enumerate(r):
            st = "TblMono" if ci in mono_cols else "Tbl"
            cells.append(Paragraph(str(c), ss[st]))
        data.append(cells)
    t = Table(data, colWidths=cw, repeatRows=1)
    style = [
        ("BACKGROUND", (0, 0), (-1, 0), TABLE_HEAD),
        ("VALIGN", (0, 0), (-1, -1), "MIDDLE"),
        ("LEFTPADDING", (0, 0), (-1, -1), 6),
        ("RIGHTPADDING", (0, 0), (-1, -1), 6),
        ("TOPPADDING", (0, 0), (-1, -1), 4.5),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 4.5),
        ("LINEBELOW", (0, 0), (-1, 0), 0.8, BRAND_DARK),
        ("LINEBELOW", (0, 1), (-1, -1), 0.3, RULE),
        ("GRID", (0, 0), (-1, -1), 0.25, colors.white),
    ]
    for i in range(1, len(data)):
        if i % 2 == 0:
            style.append(("BACKGROUND", (0, i), (-1, i), TABLE_ALT))
    t.setStyle(TableStyle(style))
    return t


def callout(ss, title, body, kind="note"):
    if kind == "warn":
        bg, br, label = WARN_BG, WARN_BR, title
    else:
        bg, br, label = NOTE_BG, NOTE_BR, title
    inner = [Paragraph(label, ss["CalloutH"]), Spacer(1, 2)]
    if isinstance(body, str):
        body = [body]
    for b in body:
        inner.append(Paragraph(b, ss["Callout"]))
    t = Table([[inner]], colWidths=[PAGE_W - LM - RM])
    t.setStyle(TableStyle([
        ("BACKGROUND", (0, 0), (-1, -1), bg),
        ("LEFTPADDING", (0, 0), (-1, -1), 12),
        ("RIGHTPADDING", (0, 0), (-1, -1), 12),
        ("TOPPADDING", (0, 0), (-1, -1), 8),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 8),
        ("LINEBEFORE", (0, 0), (0, -1), 3.5, br),
    ]))
    return KeepTogether([Spacer(1, 2), t, Spacer(1, 8)])


def cover(ss, kicker, title_lines, subtitle, meta_rows):
    els = [Spacer(1, PAGE_H * 0.30)]
    tbl = Table([[Paragraph(kicker, ss["CoverMeta"])]], colWidths=[6 * cm])
    tbl.setStyle(TableStyle([
        ("BACKGROUND", (0, 0), (-1, -1), ACCENT),
        ("LEFTPADDING", (0, 0), (-1, -1), 10),
        ("RIGHTPADDING", (0, 0), (-1, -1), 10),
        ("TOPPADDING", (0, 0), (-1, -1), 4),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 4),
    ]))
    wrap = Table([[tbl]], colWidths=[PAGE_W])
    wrap.setStyle(TableStyle([("LEFTPADDING", (0, 0), (0, 0), LM),
                              ("TOPPADDING", (0, 0), (-1, -1), 0),
                              ("BOTTOMPADDING", (0, 0), (-1, -1), 0)]))
    els.append(wrap)
    els.append(Spacer(1, 14))
    for ln in title_lines:
        els.append(_cover_para(ln, ss["CoverTitle"]))
    els.append(Spacer(1, 10))
    els.append(_cover_para(subtitle, ss["CoverSub"]))
    els.append(Spacer(1, 26))
    mrows = [[Paragraph("<b>%s</b>" % k, ss["CoverMeta"]),
              Paragraph(v, ss["CoverMeta"])] for k, v in meta_rows]
    mt = Table(mrows, colWidths=[3.6 * cm, 10 * cm])
    mt.setStyle(TableStyle([
        ("TOPPADDING", (0, 0), (-1, -1), 1.5),
        ("BOTTOMPADDING", (0, 0), (-1, -1), 1.5),
        ("VALIGN", (0, 0), (-1, -1), "TOP"),
    ]))
    outer = Table([[mt]], colWidths=[PAGE_W])
    outer.setStyle(TableStyle([("LEFTPADDING", (0, 0), (0, 0), LM),
                               ("TOPPADDING", (0, 0), (-1, -1), 0)]))
    els.append(outer)
    return els


def _cover_para(text, style):
    p = Table([[Paragraph(text, style)]], colWidths=[PAGE_W - LM - 0.6 * cm])
    p.setStyle(TableStyle([("LEFTPADDING", (0, 0), (0, 0), LM),
                           ("TOPPADDING", (0, 0), (-1, -1), 0),
                           ("BOTTOMPADDING", (0, 0), (-1, -1), 0)]))
    return p
