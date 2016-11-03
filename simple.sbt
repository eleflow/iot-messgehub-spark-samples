organization := "br.com.eleflow"

organizationName := "Eleflow"

name := "streaming-kafka"

version := "1.7-SNAPSHOT"

scalaVersion := "2.10.6"

libraryDependencies ++= {
  val kafkaVersion = "0.9.0.0"
  val sparkVersion =  "1.6.1"
  Seq(
//    "org.http4s" %% "blaze-http" % "0.12.3",
//    "org.http4s" %% "http4s-core" % "0.12.3",
//    "org.http4s" %% "http4s-client" % "0.12.3",
    "org.apache.spark" %%  "spark-core"	  %  sparkVersion % "provided",
    "org.apache.spark" %%  "spark-sql"  %  sparkVersion % "provided",
    "org.apache.spark" %%  "spark-streaming"	  %  sparkVersion % "provided",
    "org.apache.spark" %% "spark-repl" % sparkVersion % "provided",
    "org.apache.kafka" % "kafka-log4j-appender" % kafkaVersion,
    "org.apache.kafka" % "kafka-clients" % kafkaVersion,
    "org.apache.kafka" %% "kafka" % kafkaVersion
  )
}

unmanagedJars in Compile := (baseDirectory.value ** "*.jar").classpath
