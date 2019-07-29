"""
G --> C
C --> G
T --> A
A --> U

Input: The input will always be a string of characters.

Output: The output should always be a string of characters. In the case of invalid input, you should output Invalid Input as a string.
"""

# val = 'C' # 'G'
# val = 'XXX' # Invalid Input
val = 'ACGTGGTCTTAA' # UGCACCAGAAUU
# val = 'ACGTXXXCTTAA' # Invalid Inpupt

dna_rna = {'G': 'C', 'C': 'G', 'T': 'A', 'A': 'U'}
# val = input()
def chk_val_is_in_dict(value):
    if len(value) == 1 and value in dna_rna:
        return dna_rna[value]
    elif len(value) > 1:
        a = ''
        for i in value:
            if i in dna_rna:
                # print(*dna_rna[i], end='')
                a += dna_rna[i]
            else:
                break
        return a

get_val = chk_val_is_in_dict(val)
if len(get_val) == len(val):
    print(get_val)
else:
    print('Invalid Input')