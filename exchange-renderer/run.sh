#!/bin/sh
set -e

echo "$@"
read -p "" arg; xargs printf '%s\n' "$arg";

exec "$@" --exchangejson=$arg