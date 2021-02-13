%dw 2.0
output text/plain
---
write(payload, 'application/flatfile', {schemaPath: "schemas/DIS.ffd",segmentIdent : "CAP-API-DATA-REQUEST"})
