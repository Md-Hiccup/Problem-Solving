"""
Validate the email id
"""
import re

def validate(inp):
    d = re.compile('^[a-z]+[a-z0-9_]*@[a-z0-9]{0,20}\.[com|in|org|gov]')
    if re.match(d, inp):
        print('valid')
    else:
        print('invalid')

inp = 'adfadf@sdf'
validate(inp)

inp = 'a23432aadfad@gmail.com'
validate(inp)

