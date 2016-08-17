#!/usr/bin/python3

import binascii

# c = ciphertext
# e = public key
# p and q = factors of modulus N

#---#
c = 29846947519214575162497413725060412546119233216851184246267357770082463030225
e = 3
p = 238324208831434331628131715304428889871
q = 296805874594538235115008173244022912163
N = p * q
phi = (p-1)*(q-1)
#---#

# Greatest common divisor finder

def egcd(a, b):
    if a == 0:
        return (b, 0, 1)
    else:
        g, y, x = egcd(b % a, a)
        return (g, x - (b // a) * y, y)

# Modular inverse finder

def modinv(a, m):
    g, x, y = egcd(a, m)
    if g != 1:
        raise Exception('No mod inverse')
    else:
        return x % m

# RSA formula

def rsa(c,e,phi):
    phi = (p-1)*(q-1)
    d = modinv(e, phi)
    m = pow(c, d, N)
    return m

# Message to ascii decode

def flag(m):
    decoded_flag = binascii.unhexlify(hex(m).strip('0x'))
    return decoded_flag

def main():
    m = rsa(c,e,phi)
    decoded_flag = flag(m)
    print(decoded_flag)

main()
