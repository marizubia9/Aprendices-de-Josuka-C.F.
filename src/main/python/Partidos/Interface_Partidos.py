#!/usr/bin/python3                                                                                                                                                                                                                           # -*- coding: utf-8 -*-

from abc import ABC, abstractmethod
from src.main.python.Partido.Partido import Partido

class Interface_Partidos ( ABC ):

    @abstractmethod
    def search_partidos( self, **kwparams) -> [ Partido ]:
        
        pass






    
