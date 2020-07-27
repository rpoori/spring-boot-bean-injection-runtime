# spring-boot-bean-injection-runtime
Spring boot app - Instead of deploying the same app with multiple profiles (as implemented in the repo spring-boot-ddd-multi-profile), 
different implementations can be injected for the same bean at runtime using qualifiers and spring plugin registry.  
So a single deployment of the app will provide different implementations based on some differentiator variable (in request header for example).
