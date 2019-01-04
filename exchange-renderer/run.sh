#!/bin/sh
set -e

echo "$@"
read -p "" arg; printf '%s\n' "$arg";

exec "$@" --exchangejson=$arg