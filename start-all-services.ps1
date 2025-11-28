Write-Host "Starting all microservices..." -ForegroundColor Green

Write-Host "`n1. Starting Discovery Service (port 8761)..." -ForegroundColor Yellow
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\bilel\Documents\DEV\JEE\Micorservice\discovery-service'; Write-Host 'Discovery Service starting on port 8761...' -ForegroundColor Cyan; .\mvnw.cmd spring-boot:run"

Start-Sleep -Seconds 15

Write-Host "`n2. Starting Patient Service (port 8081)..." -ForegroundColor Yellow
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\bilel\Documents\DEV\JEE\Micorservice\patient-service'; Write-Host 'Patient Service starting on port 8081...' -ForegroundColor Cyan; .\mvnw.cmd spring-boot:run"

Start-Sleep -Seconds 10

Write-Host "`n3. Starting Medecin Service (port 8082)..." -ForegroundColor Yellow
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\bilel\Documents\DEV\JEE\Micorservice\medecin-service'; Write-Host 'Medecin Service starting on port 8082...' -ForegroundColor Cyan; .\mvnw.cmd spring-boot:run"

Start-Sleep -Seconds 10

Write-Host "`n4. Starting Gateway Service (port 8888)..." -ForegroundColor Yellow
Start-Process powershell -ArgumentList "-NoExit", "-Command", "cd 'C:\Users\bilel\Documents\DEV\JEE\Micorservice\gateway-service'; Write-Host 'Gateway Service starting on port 8888...' -ForegroundColor Cyan; .\mvnw.cmd spring-boot:run"

Start-Sleep -Seconds 15

Write-Host "`nOpening Eureka Dashboard in browser..." -ForegroundColor Green
Start-Process "http://localhost:8761"

Write-Host "`nAll services are starting!" -ForegroundColor Green
Write-Host "Services will be available at:" -ForegroundColor Cyan
Write-Host "  - Discovery Service: http://localhost:8761" -ForegroundColor White
Write-Host "  - Patient Service: http://localhost:8081" -ForegroundColor White
Write-Host "  - Medecin Service: http://localhost:8082" -ForegroundColor White
Write-Host "  - Gateway Service: http://localhost:8888" -ForegroundColor White
Write-Host "`nWait a few moments for all services to fully start and register with Eureka." -ForegroundColor Yellow

