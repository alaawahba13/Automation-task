import pandas as pd

# read the file
df = pd.read_excel('./TaskData.xlsx')


# extract the years from Join Date column
# calculate the number years in VOIS
for i in range(len(df)):
    year =  df.loc[i,'Join Date'].year
    df.loc[i, 'Today , How Many years in VOIS'] = 2024 - year
    
# for some reason, the format of this column changes, this line is to keep the original formatting    
df['Join Date'] = df['Join Date'].dt.strftime('%A, %B %d, %Y')

# save changes
df.to_excel('ModifiedDataByPython.xlsx', index=False)

