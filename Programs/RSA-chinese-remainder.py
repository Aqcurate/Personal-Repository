#!usr/bin/python3

import binascii

# N1 = Modulus 1
# N2 = Modulus 2
# N3 = Modulus 3
# C1 = Ciphertext 1
# C2 = Ciphertext 2
# C3 = Ciphertext 3

#---#

n1 = 79608037716527910392060670707842954224114341083822168077002144855358998405023007345791355970838437273653492726857398313047195654933011803740498167538754807659255275632647165202835846338059572102420992692073303341392512490988413552501419357400503232190597741120726276250753866130679586474440949586692852365179

n2 = 58002222048141232855465758799795991260844167004589249261667816662245991955274977287082142794911572989261856156040536668553365838145271642812811609687362700843661481653274617983708937827484947856793885821586285570844274545385852401777678956217807768608457322329935290042362221502367207511491516411517438589637

n3 = 95136786745520478217269528603148282473715660891325372806774750455600642337159386952455144391867750492077191823630711097423473530235172124790951314315271310542765846789908387211336846556241994561268538528319743374290789112373774893547676601690882211706889553455962720218486395519200617695951617114702861810811 

c1 = 34217065803425349356447652842993191079705593197469002356250751196039765990549766822180265723173964726087016890980051189787233837925650902081362222218365748633591895514369317316450142279676583079298758397507023942377316646300547978234729578678310028626408502085957725408232168284955403531891866121828640919987

c2 = 48038542572368143315928949857213341349144690234757944150458420344577988496364306227393161112939226347074838727793761695978722074486902525121712796142366962172291716190060386128524977245133260307337691820789978610313893799675837391244062170879810270336080741790927340336486568319993335039457684586195656124176

c3 = 55139001168534905791033093049281485849516290567638780139733282880064346293967470884523842813679361232423330290836063248352131025995684341143337417237119663347561882637003640064860966432102780676449991773140407055863369179692136108534952624411669691799286623699981636439331427079183234388844722074263884842748

#---#

# Calculating the greatest common denominator (Euclidean algorithm)
# a = First number
# b = Second number
# Returns GCD 

def egcd(a, b):
    if a == 0:
        # gcd (0, b) equals b
        return (b, 0, 1)
    else:
        # gcd (a, b) equals gcd(remainder of b / a, a)  
        gcd, y, x = egcd(b % a, a)
        return (gcd, x - (b // a) * y, y)

# Calculating the modular inverse
# modinv(a, m) translates to  a*? = 1 mod modulus

def modinv(a, modulus):
    gcd, x, y = egcd(a, modulus)
    if gcd != 1:
        raise Exception('There is no modular inverse.')
    else:
        return x % modulus

# Newton's method for finding roots
def isqrt(n, k):
    u, s = n, n+1
    while u < s:
        s = u
        t = (k - 1) * s + n // pow(s, k-1)
        u = t // k
    return s

# Inputs values into chinese remainder theorem formula
def chineseremainder(n1,n2,n3):
    inv1 = modinv(n2*n3, n1)
    inv2 = modinv(n1*n3, n2)
    inv3 = modinv(n1*n2, n3)
    x = (c1*n2*n3*inv1)+(c2*n1*n3*inv2)+(c3*n1*n2*inv3)
    y = x % (n1*n2*n3)
    return y

# Roots the chinese remainder output by the encryptin key (3 in this case)
# Translates the output into ascii
def flag(y):
    flag = isqrt(y, 3)
    decoded_flag = binascii.unhexlify(hex(flag).strip('0x'))
    return decoded_flag

def main():
    y = (chineseremainder(n1,n2,n3))
    decoded_flag = flag(y)
    print(decoded_flag)

main()
