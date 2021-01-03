from abc import ABC, abstractmethod
from src.main.python.Partido.Sancion import Sancion

class Interface_Sanciones ( ABC ):
"""
interfaz que establece el método que se podrá implementar para las sanciones
"""  
    @abstractmethod
    def search_sanciones( self, **kwparams) -> [ Sancion ]:
        
        pass


