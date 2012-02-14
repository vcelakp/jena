#!/bin/bash

# You need a copy of the staging repo to get the checksum files.

# NB This fails unless this first:
# cd somewhere_clean
# NNN=....
# mkdir -p repository.apache.org/content/repositories/orgapachejena-${NNN}/org/apache/jena
#   otherwise it creates a file in this location then can't mirror below it.
#
# wget -e robots=off --wait 1 --mirror -np \
#     https://repository.apache.org/content/repositories/orgapachejena-${NNN}/org/apache/jena
# mv repository.apache.org/content/repositories/orgapachejena-${NNN} REPO
# rm -rf  repository.apache.org/

REPO=REPO/org/apache/jena
OUT="dist"

# This script collects everything for the incubator/dist/jena area
# for a TDB release. 
# It write a script that will build dist/ from rpo copy.
# Copy to dist/jena to add to the last jena release.

## To manaually sign:
# sha1sum -b FILE | cut -f1 -d' '

ECHO=echo
CPCMD="$ECHO cp"
MKDIR="$ECHO mkdir"
DELDIR="$ECHO rm -rf"

## 
echo "## Initalize"
$DELDIR $OUT
$MKDIR $OUT

function cpfile
{
    local FILE="$1"
    local DIR="$2"

    local SRC="$REPO/$FILE"
    local DEST="$OUT/$DIR"

    $CPCMD "$SRC" "$DEST"
    #for ext in asc asc.md5 asc.sha1 md5 sha1
    for ext in  asc md5 sha1
    do
	$CPCMD "$SRC.$ext" "$DEST"
    done
}

function cpallfiles
{
    local M="$1"
    local V="$2"
    local D="$M-$V-$inc"
    $MKDIR $OUT/$D
    cpfile "$M/$V-$inc/$M-$V-$inc.jar" $D
    cpfile "$M/$V-$inc/$M-$V-$inc-sources.jar" $D
    if [ -e "$REPO/$M/$V-$inc/$M-$V-$inc-javadoc.jar" ]
    then
	 cpfile "$M/$V-$inc/$M-$V-$inc-javadoc.jar" $D
    else
	$ECHO echo "No javadoc: $REPO/$M/$V-$inc/$M-$V-$inc-javadoc.jar"
    fi
    cpfile "$M/$V-$inc/$M-$V-$inc-source-release.zip" $D
}

## ToDo: automate

V_TDB=0.9.0
inc=incubating

## Top level directory

## Modules

echo "## TDB"
cpallfiles jena-tdb "${V_TDB}"

echo "## zip"
M=jena-tdb
V=${V_TDB}
D="$M-$V-$inc"
cpfile $M/$V-$inc/$D-distribution.zip      .
cpfile $M/$V-$inc/$D-distribution.tar.gz   .

# Fix the name.
for ext in {zip,tar.gz}{,.asc,.md5,.sha1}
do
    $ECHO mv $OUT/$M-$V-$inc-distribution.$ext $OUT/apache-$M-$V-$inc.$ext
done