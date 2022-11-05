#! /usr/bin/python 
# -- coding: ISO-8859-1 --
from math import sqrt

#La fonction de PGCD
def pgcd(a,b):
     while b!=0 : 
        a,b = b, int(a) % int(b)
     return a

#La fonction de test de primalité
def primaliter(n):
    d=2
    r=int(n)%d
    if r==0:
     return False
    d=3
    while d<=sqrt(int(n)):
        r=int(n)%d
        if r==0:
            return False
        d=d+2
    return True

#La fonction pour inversion modulaire
def modulo(a,b):
    for n in range(b):
        if(a*n)%b==1:
            return n
            break
        elif n==b-1:
            return "Null"
        else:
            continue

#La fonction exponentiation modulaire    
def expo(a,b,n):
    resultat=1
    while b>0:
        if b&1>0:
            resultat=(resultat*a)%n
        b >>= 1
        a= (a*a)%n    
    return resultat

#La fonction d'Euclide etendu pour calculer d
def TrouverD(e, phi) :
  d=1 
  temp=(int(e)*d)%int(phi)
  while(temp!=1):
    d=d+1
    temp=(int(e)*d)%int(phi)
  return d

def chiff(m,e,n):
     nbr_chiffre = pow(int(m),int(e),int(n))
     return nbr_chiffre

def dichff(c,d,n):
     resultat=pow(int(c),int(d),int(n))
     return resultat

#La fonction main
def main():
     print("*****************Bonjour dans le programme de RSA************************")
     p=input("Merci d'entrer un nombre premiere P: ")
     while primaliter(p)== False:
          p=input("P n'est pas première, Merci d'entrer un autre nombre premiere : ")
     print("p=",p)
     q=input("Merci d'entrer un autre nombre premiere Q :")
     while primaliter(q)== False:
          q=input(" Q n'est pas première, Merci d'entrer un autre nombre premiere : ")
     print("q=",q)
     n=int(p)*int(q)
     print("n=p*q = ",n)
     e=input("Merci d'entrer la clé public e : ")
     while primaliter(e)== False:
          if pgcd(e, n)!=1:
               e=input("Entrer e : ")
     phi=(int(p)-1)*(int(q)-1)
     print("phi=",phi)
     d=TrouverD(e, phi)
     print("Clé publique : ", e, ", Clé privée : " , d)
     nombre=input("Merci d'entrer un nombre pour le chiffrer : ")
     chiffrer=chiff(nombre,e,n)
     print("Le nombre entrer avec le chiffremet est : ", chiffrer)
     dechiffrer=dichff(chiffrer,d,n)
     print("Le nombre après le dechiffremet est : ", dechiffrer)
