#!/usr/bin/python

import numpy, textwrap

#---#
alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789_{}"
ciphertext = "7Nv7}dI9hD9qGmP}CR_5wJDdkj4CKxd45rko1cj51DpHPnNDb__EXDotSRCP8ZCQ"
matrix1 = numpy.matrix([[54, 53, 28, 20, 54, 15, 12, 7],
                        [32, 14, 24, 5, 63, 12, 50, 52],
                        [63, 59, 40, 18, 55, 33, 17, 3],
                        [63, 34, 5, 4, 56, 10, 53, 16],
                        [35, 43, 45, 53, 12, 42, 35, 37],
                        [20, 59, 42, 10, 46, 56, 12, 61],
                        [26, 39, 27, 59, 44, 54, 23, 56],
                        [32, 31, 56, 47, 31, 2, 29, 41]])

#---#

# Create a dictionary for encrypting and decrypting based on alphabet
def dictionary():
    decrypt = {}
    encrypt = {}

    for k in range(len(alphabet)):
        decrypt[k] = alphabet[k]
        encrypt[alphabet[k]] = k
    
    return decrypt, encrypt

# Preping the ciphertext
def convert_ciphertext(encrypt):
    converted_ciphertext = []
    # Split ciphertext into equal parts using the size of the matrix
    spliced_ciphertext = textwrap.wrap(ciphertext, len(matrix1))
    # Convert ciphertext using the encrypt dictionary
    # Place everything into a list
    for k in spliced_ciphertext:
        converted_subtext = ""
        for index, n in enumerate(k):
            converted_subtext += str(encrypt[n])
            if index is not len(matrix1)-1:
                converted_subtext += ", "
        converted_ciphertext.append(converted_subtext)
    
    return converted_ciphertext

# Decrypting the transformed ciphertext
def decrypt_ciphertext(decrypt, decrypted_ciphertext):
    plaintext = []
    for k in decrypted_ciphertext:
        plaintext.append(decrypt[k])

    return plaintext


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


def linear_eq_solve(converted_ciphertext):
    determinent = numpy.linalg.det(matrix1)
    # Weird conversion hack to convert float64 -> int
    determinent_str = str(determinent).replace('.0', '')
    # Calculate inverse determinent using modinv()
    inverse_determinent = modinv(int(determinent_str), len(alphabet))
    # Calculate the mod inverse matrix using the normal inverse
    modular_inverse_matrix = numpy.around(matrix1.I * determinent)*inverse_determinent % len(alphabet)

    decrypted_ciphertext = []
    for i in converted_ciphertext:
        # Set matrix to first block in ciphertext 
        matrix2 = numpy.matrix(i)
        # Multiply the matrices and mod it by the len of alphabet
        # Convert result to list
        decrypted_list = numpy.matrix.tolist((modular_inverse_matrix * matrix2.T) % len(alphabet))

        # Convert multidimentional list to a 1-D list
        for j in decrypted_list:
            for k in j:
                decrypted_ciphertext.append(int(k))

    return decrypted_ciphertext



def main():
    # Get dictionaries
    decrypt, encrypt = dictionary()
    # Prep ciphertext
    converted_ciphertext = convert_ciphertext(encrypt)
    # Decrypt ciphertext
    decrypted_ciphertext = linear_eq_solve(converted_ciphertext)
    # Reconvert to plaintext using decrypt dictionary
    plaintext = decrypt_ciphertext(decrypt, decrypted_ciphertext)
    # Print flag
    print(''.join(plaintext))

main()
