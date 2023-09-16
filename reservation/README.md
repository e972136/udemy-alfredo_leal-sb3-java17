## Se hizo los siguientes cambios
### en pom
* se agrego  `<spring-cloud.version>2022.0.4</spring-cloud.version>`
* se agrego  `<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-config</artifactId>
  </dependency>` 
* se agrego `	<dependencyManagement>
  <dependencies>
  <dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-dependencies</artifactId>
  <version>${spring-cloud.version}</version>
  <type>pom</type>
  <scope>import</scope>
  </dependency>
  </dependencies>
  </dependencyManagement>`
* se agrego elementos en el properties
* se agrego reservationconfig
* se agrego model propertisreservation