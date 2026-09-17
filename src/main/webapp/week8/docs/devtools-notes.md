# DevTools Inspection Notes

## Network Tab Observation
- **HTTP Status Code:** `200 OK` (or `304 Not Modified` if cached locally)
- **Files Loaded:**
    1. `index.html`
    2. `style.css`

## Computed CSS Inspection
- **Element Inspected:** `<nav>` (or `<nav> <ul>`)
- **Computed Property:** `display: flex`
- **Computed Dimensions/Styles:**
    - `background-color`: `rgb(31, 56, 100)` (equivalent to `#1F3864`)
    - `flex-direction`: `row` (on full desktop and <= 900px viewports) / `column` (on <= 600px viewports)