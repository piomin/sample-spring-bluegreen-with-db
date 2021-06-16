FROM liquibase/liquibase
ENV URL=jdbc:postgresql://postgresql:5432/bluegreen
ENV USERNAME=bluegreen
ENV PASSWORD=postgres-secret
ENV CHANGELOGFILE=changelog.xml
CMD ["sh", "-c", "docker-entrypoint.sh --url=${URL} --username=${USERNAME} --password=${PASSWORD} --classpath=/liquibase/changelog --changeLogFile=${CHANGELOGFILE} update"]