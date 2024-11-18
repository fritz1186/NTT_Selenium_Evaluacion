#language: es

Característica: : Product - Store

  @testBensg
  Escenario: Login exitoso con usuario correcto y clave correcta
    Dado estoy en la página de la tienda
    Cuando me logueo con mi usuario "fritz.reyes11@gmail.com" y clave "Hol@Selenium"
    Entonces valido autenticacion correcta "Fritz Reyes Valera"
    Y cierro sesion