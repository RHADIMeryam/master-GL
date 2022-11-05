#! /usr/bin/python 
# -- coding: ISO-8859-1 --

import rsa_fonction

def TrouverPetQ(n):
    N=2
    while N:
        while n%N!=0:
            N=N+1
        if n/N==1 :
            global p
            p = N
            print("p= ",p)
            break
        global q
        q=N
        print("q= ",q)
        n=n/N;
    phi=(p-1)*(q-1)
    return phi

def main():
     e= 12413
     n= 13289
     M=[9197,6284,12836,8709,4584,10239,11553,4584,7008,12523,9862,356,5356,1159,10280, 12523, 7506, 6311]
     phi=TrouverPetQ(n)
     print("phi= ",phi)
     d=rsa_fonction.TrouverD(e, phi)
     for m in M:
        dechiffrer = rsa_fonction.dichff(m,d, n)
        print("%d -> %d" % (m, dechiffrer))
