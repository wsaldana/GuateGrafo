'''
Universidad del Valle de Guatemala
Algoritmos y Estructuras de Datos
Sección 20

@author Walter Saldaña #19897
@version 1.0
@since 5/14/2020

GuateGrafo
Aplicacion que permite direccionar de una posición de la Ciudad a
otra de la manera más rápida por medio de grafos, considerando los
cordones sanitarios del Covid-19.
'''
import networkx as nx
G = nx.DiGraph()

with open("guategrafo.txt") as file:
    for line in file:
        print(line)
        lst = line.split(" ")
        if(lst[0] not in G.nodes):
            G.add_node(lst[0])
        if(lst[1] not in G.nodes):
            G.add_node(lst[1])
        G.add_weighted_edges_from([(lst[0],lst[1],int(lst[2]))])

print("\n---GUATEGRAFOS---")

while True:
    print("\nIngrese una opcion:")
    print("\t1. Ruta \n\t2. Centro \n\t3. Modificar \n\t4. Salir")
    opc = input("Por favor ingrese una opcion: ")
    if(opc == "1"):
        partida = input("Ingrese el nombre del punto de partida: ")
        destino = input("Ingrese el nombre del punto de destino: ")
        try:
            print("Total de Km: "+str(nx.floyd_warshall(G)[partida][destino]))
            print("Ruta mas corta: "+str(nx.shortest_path(G,source=partida,target=destino, weight='weight')).replace("', '"," -> ").replace("['","").replace("']",""))
        except:
            print("No se ha encontrado la ruta deseada")
    elif(opc == "2"):
        try:
            print("El centro esta en: "+nx.center(G))   
        except:
            print("El nodo no cumple los requisitos para tener un centro ") 
        
    elif(opc == "3"):
        opc2 = input("Desea\n\t1. Desconectar ruta \n\t2. Conectar ruta\n ")
        p1 = input("Ingrese el punto de partida: ")
        p2 = input("Ingrese el punto de destino: ")
        if(opc2 == "1"):
            try:
                G.remove_edge(p1,p2)
                print("Operacion realizada exitosamente")
            except:
                print("No se ha encontrado la ruta deseada")
        elif(opc2 == "2"):
            w = input("Ingrese la distancia en Km: ")
            try:
                G.add_weighted_edges_from([(p1,p2,int(w))])
                print("Operacion realizada exitosamente")
            except:
                print("No se ha encontrado la o las ciudades ingresadas")
        else:
            print("Por favor ingrese una opcion valida...")
    elif(opc == "4"):
        print("Que tenga un bien dia!!")
        break
    else:
        print("Por favor ingrese una opcion valida...")
        
        
        
        
