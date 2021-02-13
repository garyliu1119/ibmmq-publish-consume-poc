%dw 2.0
output application/json
fun getArrayOfData (aString) = splitBy(aString replace /\s+/ with " ", " ")
---
{
	correlationId: correlationId,
	fName: getArrayOfData(payload)[2],
	headerCid: attributes.headers.correlationId
}

