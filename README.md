<div style="text-align: center;">
  <img src="./miscellaneous/MusicList.svg" alt="Music List" width="100%">
</div>

# 🎧 music-list-2023-3

**Music List** is a dynamic and engaging web full stack application designed to cater to music enthusiasts and administrators alike. Seamlessly blending user interaction with administrative control, the app revolves around two distinct roles: User and Administrator.

As a **_User_**, you'll be able to explore an extensive catalog of songs spanning various genres. Dive into a world of music discovery by browsing through an eclectic collection of tracks, each accompanied by detailed information about the artist, album, and genre. Additionally, users have the power to cast their votes for their favorite songs, contributing to a dynamic ranking system that showcases the most popular tracks within the community.

On the other hand, as an **_Administrator_**, you wield the ability to curate the musical experience. Shape the platform's content by creating and managing music genres, ensuring that the catalog remains diverse and comprehensive. Furthermore, administrators hold the privilege of adding new songs to the platform, including essential metadata like title, artist, and album details.

With a clean and intuitive user interface, **Music List** offers a seamless experience to both **_Users_** and **_Administrators_**. Users can effortlessly explore, vote, and engage with music, while Administrators can exercise creative control over the platform's content, fostering a vibrant and interactive community of music lovers. Whether you're a casual listener or a dedicated curator, **Music List** provides a platform where the world of music converges with the power of technology.

## 🖥️ Tech Stack

**Front-End**

- [Angular](https://angular.io/)
- [TailwindCSS](https://tailwindcss.com/)

**Back-end**

- [Spring boot](https://spring.io/)
- [MySQL](https://www.mysql.com/)
- [JWT](https://jwt.io/)

## 👟 Run Locally

Clone the project

```bash
  git clone https://github.com/alejandronoss1017/music-list-2023-3
```

### Back-end

#### Environment Variables

To run this project, you will need to add the following environment variables

`DB_URL`

`DB_PORT`

`DB_SCHEMA`

`DB_USER`

`DB_PASSWORD`

> Optional could be `${SPRING_PROFILES_ACTIVE}`, you can set it to `dev` or `production`, or just specify it in as a program argument.

Go to the back-end project directory

```bash
  cd music-list-2023-3/back-end
```

Create a jar file

```bash
  mvn package
```
>Note: You could use -DskipTests argument to skip the tests

Execute the jar file

```bash
  java -jar -Dspring.profiles.active=dev target/music-list-0.0.1-SNAPSHOT.jar
```
>Note: If you are using Windows powershell, you need to use double quote on the program argument, like this: "-Dspring.profiles.active=dev"

Start the server (Without creating the jar file)

```bash
  mvn spring-boot:run
```
>Note: You could use -Dspring-boot.run.profiles=dev argument to specify the profile

**Front-end**

Go to the front-end directory

```bash
  cd music-list-2023-3/front-end
```

Start the server

```bash
  ng serve -o
```

## Authors

- [@alejandronoss1017](https://github.com/alejandronoss1017)
- [@carlosantiagorojas](https://github.com/carlosantiagorojas)
- [@StiivenOrtiz](https://github.com/StiivenOrtiz)
- [@GianlucaGav](https://github.com/GianlucaGav)
