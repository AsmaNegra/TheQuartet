# 🎭 Orchestra – Plateforme Culturelle Événementielle

**Orchestra** est une plateforme web innovante développée dans le cadre du projet universitaire à **Esprit School of Engineering**. Elle permet à tout utilisateur de **réserver**, **acheter des tickets** et **organiser des événements culturels** de A à Z.  
Elle s’adresse à la fois aux passionnés de culture souhaitant participer à des événements, et aux organisateurs désireux de promouvoir leurs créations.

---

## 📑 Table des matières

- [📄 Description](#-description)
- [⚙️ Installation](#️-installation)
- [🚀 Utilisation](#-utilisation)
- [🛠️ Technologies utilisées](#-technologies-utilisées)

---

## 📄 Description

**🎯 Objectif :**  
Offrir une solution complète de gestion d’événements culturels : de la conception à la billetterie.

**🔧 Problème résolu :**  
Simplifier l’organisation d’événements et rendre leur accès plus facile au public via une interface centralisée.

**⭐ Fonctionnalités principales :**
- 🎫 Réservation de tickets
- 🛒 Achat en ligne sécurisé
- 📅 Création d'événements avec personnalisation
- 📲 Génération de QR codes pour les billets
- 📊 Statistiques d'événement en temps réel
- 🔐 Gestion des profils utilisateurs et organisateurs
- 📅 Tableau Kanban des tâches à réaliser pour l'évenement
- 📊 Une liste préremplie de fournisseurs collaborateurs

---

## ⚙️ Installation

1. **Cloner le repository :**
```bash
git clone https://github.com/Projet-technologies-web-2A/TheQuartet.git
cd TheQuartet
````

2. **Pré-requis :**

   * Java JDK 17+
   * Maven
   * MySQL
   * IDE recommandé : IntelliJ IDEA

3. **Configurer la base de données :**

   * Créer une base de données nommée `quartet_db`
   * Modifier `src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quartet_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```


---

## 🚀 Utilisation

### Pour les utilisateurs

* Parcourir les événements disponibles
* Réserver et payer en ligne
* Recevoir un ticket avec QR Code

### Pour les organisateurs

* Créer un compte et publier un événement
* Gérer les réservations et l'accès
* Suivre les progrès de l'organisation via des tâches partagées entre l’équipe

---

## 🛠️ Technologies utilisées

* **Java 17**, **Spring Boot**
* **MySQL** (gestion de base de données)
* **Maven** (gestionnaire de dépendances)
* **QRCode Generator**
* **AI**
* **HTML/CSS/JavaScript**
* Hébergement GitHub
* Projet réalisé dans le cadre du cours PIDEV à **Esprit School of Engineering**

---

