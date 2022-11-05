import random
import rsa_fonction

def exo5():
    
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
     message=input("Merci d'entrer le message pour le chiffrer : ")
     taille=len(message)
     if (len(message)%2 != 0): message= message+ '.'
     i = 0
     messageCrypter= []
     while i < taille:
         
        a = ord(message[i])
        b = ord(message[i+1])
        messageConcatiner = str(a-23) + str(b-23)
        messageConcatiner = int (messageConcatiner)
        print ("bloc",messageConcatiner)
        lettreCrypter = pow( messageConcatiner,int(e))%n
        messageCrypter.append(lettreCrypter)
        i=i+2
     print ("Le message entrer crypter : ", messageCrypter)
