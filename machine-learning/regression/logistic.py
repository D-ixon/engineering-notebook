import pandas as pd
import numpy as np

train = pd.read_csv('data/sonar.csv', header=None)
alpha = 0.5

def process_data(train):

    X_train = train.iloc[:, :-1]
    y_train = train.iloc[:, -1]

    y_encode = y_train.map({'R': 0, 'M': 1})

    X = X_train.to_numpy()
    Y = y_encode.to_numpy()

    return X, Y

