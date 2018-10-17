#!/bin/sh
if ! whoami &> /dev/null; then
  if [ -w /etc/passwd ]; then
    echo "${USER_NAME:-kv1995}:x:$(id -u):0:${USER_NAME:-kv1995}
user:${HOME}:/sbin/nologin" >> /etc/passwd
  fi
fi

