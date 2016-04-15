name := "streaming-kafka"

version := "1.6"

scalaVersion := "2.10.4"

libraryDependencies ++= {
  val sparkVersion =  "1.6.0"
  Seq(
    "org.apache.spark" %%  "spark-core"	  %  sparkVersion % "provided",
    "org.apache.spark" %%  "spark-sql"  %  sparkVersion % "provided",
    "org.apache.spark" %%  "spark-streaming"	  %  sparkVersion % "provided",
    "org.apache.spark" %% "spark-repl" % sparkVersion % "provided",
    "org.apache.kafka" % "kafka-log4j-appender" % "0.9.0.0",
    "org.apache.kafka" % "kafka-clients" % "0.9.0.0",
    "org.apache.kafka" %% "kafka" % "0.9.0.0"
  )
}

unmanagedJars in Compile := (baseDirectory.value ** "*.jar").classpath
