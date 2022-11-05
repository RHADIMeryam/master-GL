import rsa_fonction


def main():
     print("*****************Bonjour dans le programme de RSA************************")
     p=input("Merci d'entrer un nombre premiere P: ")
     while rsa_fonction.primaliter(p)== False:
          p=input("P n'est pas première, Merci d'entrer un autre nombre premiere : ")
     print("p=",p)
     q=input("Merci d'entrer un autre nombre premiere Q :")
     while rsa_fonction.primaliter(q)== False:
          q=input(" Q n'est pas première, Merci d'entrer un autre nombre premiere : ")
     print("q=",q)
     n=int(p)*int(q)
     print("n=p*q = ",n)
     e=input("Merci d'entrer la clé public e : ")
     while rsa_fonction.primaliter(e)== False:
          if rsa_fonction.pgcd(e, n)!=1:
               e=input("Entrer e : ")
     phi=(int(p)-1)*(int(q)-1)
     print("phi=",phi)
     d=rsa_fonction.TrouverD(e, phi)
     print("Clé publique : ", e, ", Clé privée : " , d)
     nombre=input("Merci d'entrer un nombre pour le chiffrer : ")
     chiffrer=rsa_fonction.chiff(nombre,e,n)
     print("Le nombre entrer avec le chiffremet est : ", chiffrer)
     dechiffrer=rsa_fonction.dichff(chiffrer,d,n)
     print("Le nombre après le dechiffremet est : ", dechiffrer)
