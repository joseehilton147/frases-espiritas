$SCRIPT_DIR = Split-Path -Parent $MyInvocation.MyCommand.Definition
$MIGRATION_DIR = "$SCRIPT_DIR\..\src\main\resources\db\migration"
$MIGRATION_DIR = (Resolve-Path $MIGRATION_DIR).Path

# Criar o diretório de migrações se não existir
if (!(Test-Path -Path $MIGRATION_DIR)) {
    New-Item -ItemType Directory -Path $MIGRATION_DIR -Force | Out-Null
}

# Encontrar a última versão existente
$latest_version = (Get-ChildItem -Path $MIGRATION_DIR -Filter "V*__*.sql" |
    ForEach-Object { $_.Name -match "^V(\d+)__" ; [int]$matches[1] } |
    Sort-Object -Descending | Select-Object -First 1)

if ($latest_version -eq $null) {
    $latest_version = 0
}

# Próxima versão
$next_version = $latest_version + 1

# Criar o novo arquivo de migração
$MIGRATION_NAME = $args[0]  # Garantir que o argumento seja tratado como string
$filename = "$MIGRATION_DIR\V$next_version`__$MIGRATION_NAME.sql"
New-Item -ItemType File -Path $filename | Out-Null
Write-Host "✅ Nova migração criada: $filename"