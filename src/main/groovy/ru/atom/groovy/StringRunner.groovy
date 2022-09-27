package ru.atom.groovy

/**
 * " "
 * ' '
 * """ """
 * ''' '''
 * /  /
 * $/ $/
 */
def name = "Max"
def str1 = "str1"
def str2 = 'str2'
def str3 = """
SELECT * FROM table
WHERE name_prefix = ${getPrefixName(name)}
"""
def str4 = '''str4'''
def str5 = /str5 $name/
def str6 = $/str6/$

println str5
println str3
println name * 3
println name - "M"
println name - "1"
println name + "M"
println name[2]
println name[1..2]

def getPrefixName(String name) {
    return "prefix->{$name}"
}