image = """
                            name
        Rajesh          
    \/\             address         
   \r\t                 Hsr valueleaf team
            pincode     
        89774937
"""


""" Try 1 """
import re
import json
line1 = re.split('\n', image)

i = 0
d = {}
while (i <= len(line1)):
    try:
        if len(line1[i]) > 1:
            tt1 = re.sub('\W', " ", line1[i]).strip()
            tt2 = re.sub('\W', " ", line1[i + 1]).strip()
            # t1 = ' '.join([i for i in re.split('\W', line1[i]) if len(i) > 1])
            # t2 = ' '.join([i for i in re.split('\W', line1[i + 1]) if len(i) > 1])
            d[tt1] = tt2
            i += 2
        else:
            i += 1
    except IndexError as e:
        break
print(d)
# print(json.dumps(d))