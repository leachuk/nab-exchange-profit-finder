#!/bin/sh
set -e

echo "$@"
read -p "" arg; echo $arg;

exec "$@" --exchangejson=$arg