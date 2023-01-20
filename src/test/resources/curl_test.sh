#!/bin/bash

SERVER=http://localhost:8080

SCRIPT_DIR=$(
  cd $(dirname $(readlink -f $0 || echo $0))
  pwd -P
)
cd ${SCRIPT_DIR}

curl -X POST "${SERVER}/fulfillment" \
  -v \
  -H "Content-Type: application/json" \
  -d '{"requestId":"1234567890", "inputs":[{ "intent":"action.devices.SYNC" }]}'
