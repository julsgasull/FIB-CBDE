# FIB-CBDE
FIB, Conceptes per a Bases de Dades Especialitzades

## Avaluació

### Cas normal
Nota final = 70% min(10,P) + 20%EX + 10%C

EX = nota de l'examen parcial (no hi ha final)
P = promig ponderat de les notes dels qüestionaris i de les sessions de laboratori
C = avaluació entre companys

Càlcul de P:
1. Multiplicar la nota obtinguda a cadascuna de les activitats per un pes igual a 1, 2, 4 o 8 (depenent del contingut de l'activitat en questió)
2. Dividir la suma d'aquests valors per la suma de pesos assignats menys 6

Càlcul de C: els estudiants tindran diverses parelles durant el semestre. Al final hauran de valorar-les segons 5 criteris: contribucions, abilitat per resoldre problemes, actitud, preparació, treball en equip i concentració. Prenent com a base aquestes valoracions, el professor assignarà la nota.

S = nota dels seminaris (assistència, participació i qüestionaris)

### Cas COVID-19
Donat que pot passar que alguns estudiants hagin de quedar-se a casa al desenvolupar síntomes o s'hagin de confinar per contacte amb tercers infectats, s'anul·len les activitats de classe obligatòries. D'aquesta manera, cap acte avaluatori requerirà de la presència de l'estudiant a una aula. Els percentatges d'avaluació es mantenen igual. Els laboratoris, com s'explica al punt anterior, no requereixen avaluació síncrona i no hi haurà exercicis de classe que computin per la nota de pràctiques / exercicis.

## ContingutsIntroducció 
1. Introducció 
> - Paradigma one size fits all. 
> - Colls d'ampolla de les bases de dades relacionals. 
> - Els sistemes distribuïts no relacionals con a solució. 
> - Nous reptes i oportunitats.
2. Fonaments de bases de dades distribuïdes 
> - Les noves arquitectures de bases de dades tenen un tret en comú: la distribució de les dades com a estratègia per afrontar volums ingents de dades.
> -  Aquest bloc es divideix en quatre grans apartats: 
> > 1. Introducció: 
> > > - Taxonomia de bases de dades distribuïdes. 
> > > - Arquitectures. 
> > > - Disseny de bases de dades distribuïdes (fragmentació i replicació). 
> > > - Mesures d'escalabilitat.
> > 2. Optimització de consultes en sistemes distribuits: 
> > > - Optimització semàntica, sintàctica i física de consultes. 
> > > - Paral·lelisme. 
> > > - Bases de dades paral·leles.
> > 3. Concurrència en sistemes distribuïts: 
> > > - Extensions del mòdul de concurrència d'un sistema centralitzat per adaptar-ho a entorns distribuïts. 
> > > - CAP theorem. 
> > > - Two-phase locking. 
> > > - Multi-versió. 
> > > - Time-stamping. 
> > > - Tècniques optimistes. 
> > > - Eventually consistent.
> > 4. Recuperació en sistemes distribuïts: 
> > > - Extensions del mòdul de recuperació d'un sistema centralitzat per adaptar-ho a entorns distribuïts. 
> > > - Checkpointing. 
> > > - Multi-level recovering. 
> > > - ARIES. 
> > > - 2-phase commit protocol. 
> > > - 3-phase commit protocol.
3. NOSQL 
> - Sota l'etiqueta NOSQL trobem els nous sistemes distribuïts que relaxen tots (o alguns) dels colls d'ampolla del model relacional en entorns distribuïts. 
> - En aquest curs presentem una classificació d'aquests sistemes segons quina (o quines) característiques del model relacional relaxen i en veiem els 5 més rellevants:
> > 1. Object-oriented databases. 
> > > - Introducció i assumpcions. 
> > > - Model de dades. 
> > > - Escalabilitat. 
> > > - Llenguatges d'alt nivell. 
> > > - La primera extensió del model relacional: object-relational databases. 
> > > - Similituds i diferències.
> > 2. Column-oriented stores. 
> > > - Introducció i assumpcions. 
> > > - Model de dades. 
> > > - Escalabilitat. 
> > > - Llenguatges d'alt nivell. 
> > > - Extensions relacionals DSS.
> > 3. Key-value stores. 
> > > - Introducció i assumpcions. 
> > > - Model de dades. 
> > > - Escalabilitat. 
> > > - Llenguatges d'alt nivell. 
> > > - MapReduce.
> > 4. Document-stores. 
> > > - Introducció i assumpcions. 
> > > - Model de dades. 
> > > - XML databases. 
> > > - Escalabilitat. 
> > > - Llenguatges d'alt nivell. 
> > 5. Graph databases. 
> > > - Introducció i assumpcions. 
> > > - Model de dades. 
> > > - RDF i triple stores. 
> > > - Escalabilitat. 
> > > - Llenguatges d'alt nivell.
4. Integració de dades 
- El trencament del paradigma one size fits all comporta la co-existència de diferents gestors de bases de dades, cadascun especialitzat en un tipus d'escenari (inclús d'escenaris dintre del mateix sistema) amb unes característiques concretes. 
- Integrar (per creuar, analitzar, homogenitzar, etc.) dades provinents de diferents sistemes és, avui dia, un repte. 
- En aquest bloc ens centrem en com resoldre la integració de dades a nivell d'esquema:
> > 1. Introducció: 
> > > - Tipus d'heterogeneïtats. 
> > > - Arquitectures: LAV, GAV, GLAV, Mediators, Peer-to-peer, Ontology-based data access. 
> > 2. Processos ETL: Originalment associats als magatzems de dades, avui dia tenen un àmbit més general i són sinònims de migració de dades entre sistemes (normalment heterogenis). El punt anterior afronta l'heterogeneïtat a nivell d'esquema, mentre que els processos ETL ho fan a nivell d'instància. 
> > > - Conceptes bàsics. 
> > > - Extracció, transformació i càrrega. 
> > > - Operadors ETL.
> > 3. Molt lligat amb la integració de dades, diferents sistemes requereixen diferent nivell de qualitat de les dades, i això impacta directament en el nombre de transformacions a aplicar a les dades durant els processos de migració. 
> > > - Introducció. 
> > > - Causes. 
> > > - Mètodes i tècniques. 
> > > - Avaluació de la qualitat.