FROM liquibase/liquibase
ENV URL=jdbc:postgresql://postgresql:5432/bluegreen
ENV USERNAME=bluegreen
ENV PASSWORD=admin123
ENV CHANGELOGFILE=changelog.xml
CMD ["sh", "-c", "docker-entrypoint.sh --url=${URL} --username=${USERNAME} --password=${PASSWORD} --classpath=/liquibase/changelog --changeLogFile=${CHANGELOGFILE} update"]