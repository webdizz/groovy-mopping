require 'buildr/groovy'

artifact_ns(Buildr::Groovy::Groovyc).delete 'groovy'
artifact_ns(Buildr::Groovy::Groovyc).groovy = 'org.codehaus.groovy:groovy-all:jar:>=2.1.7'

VERSION_NUMBER = '0.0.1'
GROUP = 'name.webdizz.groovy'

repositories.remote << 'http://repo1.maven.org/maven2'

desc 'The Groovy-mopping project'
define 'groovy-mopping' do

  project.version = VERSION_NUMBER
  project.group = GROUP

  compile.with 'org.spockframework:spock-core:jar:0.7-groovy-2.0'
  package :jar
end
