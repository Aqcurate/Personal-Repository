import zipfile,itertools,string,time,sys
charset = string.ascii_letters + string.digits

def igen(thelen):
    yield (''.join(i) for i in itertools.product(charset,repeat=thelen))

if len(sys.argv) < 2:
    print("Usage: crackzip.py <filename>")
    sys.exit(1)

thefile = sys.argv[1]
print("Cracking "+thefile)
zFile = zipfile.ZipFile(thefile)

for i in range(5):
    p=igen(i)
    for thepass in next(p):
        print(thepass)
        try:
            zFile.extractall(pwd=thepass.encode())
        except zipfile.BadZipFile as e:
            continue
        except Exception as e:
            continue
        print("found password "+thepass)
        sys.exit(1)
