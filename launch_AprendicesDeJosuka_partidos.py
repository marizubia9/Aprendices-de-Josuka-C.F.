#!/usr/bin/python3
# -*- coding: utf-8 -*-

###########################
# IMPORTANT NOTE
# INSTALL LIBRARIES:
# JSON
# PYMONGO
# JSONPICLE
############################


import argparse
import sys

sys.path.extend(['./src'])
print("Python system path: {} \n\n".format(sys.path))

from flask import Flask
from flask_restful import reqparse, abort, Api, Resource

from src.main.python.Partidos.ADJPartidos.AprendicesDeJosukaPartidos import AprendicesDeJosukaPartidos
from src.main.python.Partido.Partido import Partido
from src.main.python.Partido.Equipo import Equipo

import json

app = Flask(__name__)
api = Api(app)

parser = argparse.ArgumentParser(description='Launcher for Partidos Aprendices de Josuka')
parser.add_argument('--host', type=str, default="127.0.0.1", help='Local Address in which Restful service will be listening')
parser.add_argument('--port', type=int, default=5000, help='Local port in which Restful service will be listening')
args = parser.parse_args()

print("Python version: {} \n"
      "Current platform: {} \n".format(sys.version, sys.platform))

print("Settinp-up Partidos")
print("...")
adj_partidos = AprendicesDeJosukaPartidos()

    # Create sample data
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()
adj_partidos.generate_random_partido()


print("Settinp-up ADJ Partidos [ OK ] ")


"""
Message formats
"""
partido_parser = reqparse.RequestParser()
partido_parser.add_argument('equipo1_name', type=str, help= "Equipo 1 name", required=False)
partido_parser.add_argument('equipo2_name', type=str, help= "Equipo 2 name", required=False)
partido_parser.add_argument('res_e1', type=int, help= "Res e1", required=False)
partido_parser.add_argument('res_e2', type=int, help= "Res e2", required=False)
partido_parser.add_argument('date', type=str, help= "Date %Y/%m/%d %H:%M:%S format", required=False)

class MicroServices(Resource):

    # curl http://127.0.0.1:5000/
    def get(self):
        message = "Aprendices de Josuka partidos working correctly"
        return { 'Message' : message } , 201

class Partidos_MicroService_Search_Partidos (Resource):

    # curl http://127.0.0.1:5000/Partidos/Search_Partidos
    def get(self):
        message = "Microservice working correctly"
        return { 'Message' : message } , 201


    def post(self):
        partido_args = partido_parser.parse_args()

        result = adj_partidos.search_partidos(
            equipo1_name = partido_args.equipo1_name,
            equipo2_name = partido_args.equipo2_name,
            res_e1       = partido_args.res_e1,
            res_e2       = partido_args.res_e2,
            date         = partido_args.date)

        json_result = adj_partidos.toJSON(result)
        print(json_result)
        return json.loads(json_result) , 201



api.add_resource(MicroServices, '/')
api.add_resource(Partidos_MicroService_Search_Partidos, '/Partidos/Search_Partidos')


if __name__ == '__main__':
    # Debug activates auto-reloading when code changes
    app.run(host=args.host, port=args.port, debug=True)
