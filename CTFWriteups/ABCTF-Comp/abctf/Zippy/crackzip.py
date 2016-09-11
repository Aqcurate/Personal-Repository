#!/usr/bin/python3
import zipfile,sys,string,time

def passgen():
    thepass='aaaa'
    for c0 in charset:
        for c1 in charset:
            for c2 in charset:
                for c3 in charset:
                    thepass=c0+c1+c2+c3
                    yield thepass

if len(sys.argv) < 2:
    print("Usage: crackzip.py <filename>")
    sys.exit(1)

thefile = sys.argv[1]
print("Cracking "+thefile)

zFile = zipfile.ZipFile(thefile)

charset = string.ascii_letters + string.digits

ourgen=passgen()

for value in ourgen:
    try:
        zFile.extractall(pwd=value.encode())
    except zipfile.BadZipFile as e:
        continue
    except Exception as e:
        continue
    print("found password "+value)
    time.sleep(3)
    break
