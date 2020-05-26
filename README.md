# JSpeedrun
An easy-to-use and customizable wrapper for the speedrun.com API in Java (WIP).

## Usage
This library is a *very* work-in-progress project. It is currently incomplete and has many missing features.
However, if using it in its current state is helpful, you can do so by including the artifacts from Jitpack:

#### Maven
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```

```
<dependency>
	<groupId>com.github.WalkerKnapp.JSpeedrun</groupId>
	<artifactId>jspeedrun-api</artifactId>
	<version>a53fc0fc48</version>
</dependency>
```
#### Gradle
```
repositories {
	maven { url 'https://jitpack.io' }
}
```
```
dependencies {
	implementation 'com.github.WalkerKnapp.JSpeedrun:jspeedrun-api:a53fc0fc48'
}
```