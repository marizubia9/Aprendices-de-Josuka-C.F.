from abc import ABC, abstractmethod
from src.main.python.Partido.Sancion import Sancion

class Interface_Sanciones ( ABC ):

    @abstractmethod
    def search_sanciones( self, **kwparams) -> [ Sancion ]:
        
        pass


