using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Competition
    {
        [Key]
        public int idCompetition { get; set; }

       
        [RegularExpression("^[0-9]*$", ErrorMessage = "Solo se admiten números.")]
        [Display(Name = "Código de competencia")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(50, ErrorMessage = "Debe tener mínimo dos caracteres, máximo cincuenta caracteres.", MinimumLength = 2)]
        [Index("Competition_code_Index", IsUnique = true)]
        public String code { get; set; }

      
        [Display(Name = "Descripción de la competencia")]
        [Required(ErrorMessage = "Es requerido.")]
        [StringLength(200, ErrorMessage = "Debe tener mínimo dos caracteres, máximo doscientos caracteres.", MinimumLength = 2)]
        [Index("Competition_description_Index", IsUnique = true)]
        public String description { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre de la actividad")]
        public String toUpper
        {
            get
            {
                if (description != null)
                {                   
                    description = description.ToUpper();
                }
                else
                {
                    description = "Es requerido.";
                }
                return description;
            }
            set
            {
                if (description != null)
                {
                    description = description.ToUpper();
                }
                else
                {
                    description = "Es requerido.";
                }
                description.ToUpper();
            }
        }

        public virtual ICollection<Trimester> trimesters { get; set; }
    }
}